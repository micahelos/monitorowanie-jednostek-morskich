package com.ctm.vessel.tracker.system.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctm.vessel.tracker.system.model.MapBounds;
import com.ctm.vessel.tracker.system.ports.entity.Port;
import com.ctm.vessel.tracker.system.ports.service.PortService;
import com.ctm.vessel.tracker.system.rest.service.RestService;

@Controller
public class PortController {
	private static final Logger log = LogManager.getLogger(PortController.class);

	private final RestService restService;
	private final PortService portService; 
	
	public PortController(RestService restService, PortService portService) {
		this.restService = restService;
		this.portService = portService;
	}
	
	@RequestMapping(
			value ="/ports",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Port> getPorts() {
		return portService.findAllPorts();
	}
	
	@GetMapping("/port/{id}")
	public String getPort(@PathVariable String id, Model model) {
		Port port = portService.findPortById(id);
		model.addAttribute("port", port);
		String image = restService.getGoogleSearchEngineForImagePathOfQuery("Port of " + port.getPortname());
		model.addAttribute("portImage", image);
		log.info("image: " + image);
		return "port";
	}
	
	@RequestMapping(
			value ="/portsbybound",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Port> getPorts(
			Model model,
			@RequestParam Double xMin,
			@RequestParam Double xMax,
			@RequestParam Double yMin,
			@RequestParam Double yMax,
			@RequestParam Long zoom) {
		MapBounds mapBounds = new MapBounds(xMin, xMax, yMin, yMax, zoom);
		Optional<MapBounds> mapBoundsOpt = Optional.of(mapBounds);
		List<Port> ports = portService.findByMapBounds(mapBoundsOpt.get());
		return ports;
	}
}
