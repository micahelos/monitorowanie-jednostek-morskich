package com.ctm.vessel.tracker.system.track.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ctm.vessel.tracker.system.historytracker.entity.TrackHistory;
import com.ctm.vessel.tracker.system.model.MapBounds;
import com.ctm.vessel.tracker.system.model.Track;
import com.ctm.vessel.tracker.system.model.Vessel;
import com.ctm.vessel.tracker.system.model.VesselBasicInformationCard;
import com.ctm.vessel.tracker.system.model.VesselPoint;
import com.ctm.vessel.tracker.system.ports.entity.Port;
import com.ctm.vessel.tracker.system.ports.repo.PortsRepo;
import com.ctm.vessel.tracker.system.ports.repo.TrackHistoryRepo;
import com.ctm.vessel.tracker.system.ports.service.PortService;
import com.ctm.vessel.tracker.system.rest.service.RestService;

@Service
public class TrackService {
	private static final Logger log = LogManager.getLogger(TrackService.class);

	@Autowired
	private PortsRepo portsRepo;
	@Autowired
	private TrackHistoryRepo trackHistoryRepo;
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private RestService restService;
	@Autowired
	private PortService portService;

	public TrackService(PortsRepo portsRepo, TrackHistoryRepo trackHistoryRepo, RestService restService, PortService portService) {
		this.portsRepo = portsRepo;
		this.trackHistoryRepo = trackHistoryRepo;
		this.restService = restService;
		this.portService = portService;
	}

	public void evictAllCaches() {
		cacheManager.getCacheNames().stream().forEach(cacheName -> {
			log.info("Remove:{}", cacheName);
			cacheManager.getCache(cacheName).clear();
		});
	}
	
	public List<VesselPoint> getVesselsPoints(Optional<MapBounds> mapBounds) {	
		Track[] tracks = restService.getRequestForVesselsPositions(mapBounds);
		return convertTracksToVesselPoints(tracks);
	}
	
	private List<VesselPoint> convertTracksToVesselPoints(Track[] tracks) {
		 List<VesselPoint> response = Stream.of(tracks).map(
	                track -> new VesselPoint(
	                        track,
	                        portService.getShipTypeExplained(track.getShipType()),
	                        this
	                	).initializeDestination()).collect(Collectors.toList());
	        return response;
	}
	
	@Cacheable(cacheNames = "tracks")
	public Track[] findAllVesselsInBounds() {
		//Oslo
		MapBounds bounds = new MapBounds(4.172951, 42.2756268,57.84672, 66.868192, 10L);
		Track[] tracks = restService.getRequestForVesselsPositions(Optional.of(bounds));
		log.info("BATCH Size:{}", tracks.length);
		return tracks;
	}
	
	public List<TrackHistory> insertHistory(Track[] tracks) {
		List<TrackHistory> trackHistory = Stream.of(tracks).map(e -> new TrackHistory(e)).collect(Collectors.toList());
		try {
			trackHistory = trackHistoryRepo.saveAll(trackHistory);
		} catch (DataIntegrityViolationException de) {
			log.warn("Duplicate value");
		} catch (Exception e) { 
			log.error("", e);
		} 
		return trackHistory;
	}
	
	public void insertHistory(Track track) {
		TrackHistory history = new TrackHistory(track);
		try {
			log.info("upsert: name:{}, MMSI:{}, timestamp:{}", history.getName(), history.getMMSI(), history.getTimestamp());
			trackHistoryRepo.upsert(history.getMMSI(), history.getDestination(), history.getLat(), history.getLng(), history.getName(), history.getSog(), history.getTimestamp());
		} catch (Exception e) { 
			log.error("", e);
		} 
	}
	
	public Optional<Port> findDestination(String destination) {
		String portName = destination == null || destination.isBlank() ? "" : destination.toLowerCase(); 
		Optional<Port> port = portsRepo.findDestination(portName).stream().findFirst();
		log.info("Port: {}, found:{}", port.isPresent(), port.isPresent() ? port.get().getLatitude() + " " + port.get().getLongitude() : " notFound");
		return port;
	}
	
	public VesselBasicInformationCard getVesselInfoByMMSI(Long mmsi) {
		Vessel vessel = restService.getVesselByMMSI(mmsi);
		String imgSrc = restService.getGoogleSearchEngineForImagePathOfQuery(vessel.getName());
		String shipTypeExplained = portService.getShipTypeExplained(vessel.getShipType());
		return new VesselBasicInformationCard(vessel, imgSrc, shipTypeExplained);
	}

	public List<TrackHistory> getVesselHistoryByMMSI(Long mmsi) {
		List<TrackHistory> list = trackHistoryRepo.findByMMSI(mmsi);
		log.info("listSize:{}", list.size());
		return list;
	}
}
