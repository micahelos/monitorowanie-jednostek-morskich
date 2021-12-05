package com.ctm.vessel.tracker.system.controllers;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ctm.vessel.tracker.system.model.MapBounds;
import com.ctm.vessel.tracker.system.model.VesselPoint;
import com.ctm.vessel.tracker.system.track.service.TrackService;

@Controller
public class MapController {
	private static final Logger log = LogManager.getLogger(MapController.class);

	@Autowired
	private TrackService trackService;

	@GetMapping
	public String getMap(Model model) {
//		model.addAttribute("tracks", trackService.getVesselsPoints());
//		model.addAttribute("ports", trackService.findAllNorthEuropeanPorts());
		return "map";
	}
	
	
	@RequestMapping(
			value ="/map",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<VesselPoint> getMapBound(
			Model model,
			@RequestParam Double xMin,
			@RequestParam Double xMax,
			@RequestParam Double yMin,
			@RequestParam Double yMax,
			@RequestParam Long zoom) {
		MapBounds mapBounds = new MapBounds(xMin, xMax, yMin, yMax, zoom);
		Optional<MapBounds> mapBoundsOpt = Optional.of(mapBounds);
		List<VesselPoint> points = trackService.getVesselsPoints(mapBoundsOpt);
		return  points;
	}
	
	@RequestMapping(
			value ="/allPoints",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<VesselPoint> getPoints() {
		return trackService.getVesselsPoints(Optional.empty());
	}
}
