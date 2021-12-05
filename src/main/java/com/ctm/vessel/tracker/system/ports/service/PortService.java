package com.ctm.vessel.tracker.system.ports.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ctm.vessel.tracker.system.model.MapBounds;
import com.ctm.vessel.tracker.system.ports.entity.Port;
import com.ctm.vessel.tracker.system.ports.repo.PortsRepo;
import com.ctm.vessel.tracker.system.shiptype.entity.Shiptype;
import com.ctm.vessel.tracker.system.shiptype.repo.ShiptypeRepo;

@Service
public class PortService {
	private static final Logger log = LogManager.getLogger(PortService.class);
	private final static List<Shiptype> ships = new LinkedList<>();
	private final static List<Port> ports = new LinkedList<>();

	@Autowired
	private ShiptypeRepo shiptypeRepo;
	@Autowired
	private PortsRepo portsRepo;
	
	public PortService(ShiptypeRepo shiptypeRepo, PortsRepo portsRepo) { 
		this.shiptypeRepo = shiptypeRepo;
		this.portsRepo = portsRepo;
		initializePortsAndShips();
	}


	public void initializePortsAndShips() {
		ships.addAll(findAllShiptype());
		ports.addAll(findAllPorts());
	}
	

	@Cacheable(cacheNames = "AllNorthEuropeanPorts")
	public List<Port> findAllNorthEuropeanPorts () {
		List<Port> list = new LinkedList<Port>();
		list.addAll(portsRepo.findByIso3("POL"));
		list.addAll(portsRepo.findByIso3("DEU"));
		list.addAll(portsRepo.findByIso3("NOR"));
		list.addAll(portsRepo.findByIso3("SWE"));
		list.addAll(portsRepo.findByIso3("FIN"));
		list.addAll(portsRepo.findByIso3("DNK"));
		list.addAll(portsRepo.findByIso3("LTU"));
		list.addAll(portsRepo.findByIso3("GRL"));
		list.addAll(portsRepo.findByIso3("GRL"));
		list.addAll(portsRepo.findByIso3("FRA"));
		list.addAll(portsRepo.findByIso3("GBR"));
		list.addAll(portsRepo.findByIso3("ISL"));
		list.addAll(portsRepo.findByIso3("EST"));
		return list;
	}
	
	@Cacheable(cacheNames = "AllShiptype")
	public List<Shiptype> findAllShiptype() {
		return shiptypeRepo.findAll();
	}
	
	@Cacheable(cacheNames = "AllPortsByISO")
	public List<Port> findAllPortsByISO(String iso) {
		List<Port> list = portsRepo.findByIso3(iso);
		return list;
	}
	
	public Port findPortById(String id) {
		Optional<Port> port = portsRepo.findById(id);
		log.info("port:{}", port.get().getPortname());
		return port.orElse(new Port());
	}
	
	@Cacheable(cacheNames = "ports")
	public List<Port> findAllPorts() {
		List<Port> list = portsRepo.findAll();
		return list;
	}
	
	public String getShipTypeExplained(int id) {
		return ships.stream().filter(e -> e.getId() == id).map(group -> group.getClassification()).findFirst().orElseGet(() -> "Unknown");
	}
	
	public List<Port> findByMapBounds(MapBounds mapBounds) {
		//lat:59.73301	lng:10.23376
		/*xMin:9.461975097656252
				xMax:12.053375244140625
				yMin:59.53779926637251
				yMax:60.28136615149061
				zoom:10
		*/
		List<Port> portList = ports.stream().filter(p -> p.getLongitude() >= mapBounds.getMinX() && p.getLongitude()<=mapBounds.getMaxX() 
																			&& p.getLatitude() >= mapBounds.getMinY() && p.getLatitude() <= mapBounds.getMaxY())
																			.collect(Collectors.toList());
		return portList;
	}
}
