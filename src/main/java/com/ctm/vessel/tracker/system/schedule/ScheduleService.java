package com.ctm.vessel.tracker.system.schedule;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.ctm.vessel.tracker.system.model.Track;
import com.ctm.vessel.tracker.system.track.service.TrackService;

@Service
public class ScheduleService {
	private static final Logger log = LogManager.getLogger(TrackService.class);

	@Autowired
	private TrackService trackService;
	
	public ScheduleService(TrackService trackService) {
		this.trackService = trackService;
	}
	
	@Scheduled(cron = "0 0/15 * * * ?")
	private void updateVesselsTrackHistory() {
		StopWatch sw = new StopWatch();
		sw.start();
		trackService.evictAllCaches();
		Track[] tracks = trackService.findAllVesselsInBounds();
		for(Track track : tracks) {
			trackService.insertHistory(track);
		}
		sw.stop();
		log.info("Find:{} and insert time: {}", tracks.length, sw.getTotalTimeSeconds());
	}
}
