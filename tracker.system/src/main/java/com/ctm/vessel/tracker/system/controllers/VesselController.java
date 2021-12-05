package com.ctm.vessel.tracker.system.controllers;

import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ctm.vessel.tracker.system.model.Track;
import com.ctm.vessel.tracker.system.rest.service.RestService;
import com.ctm.vessel.tracker.system.track.service.TrackService;

@Controller
public class VesselController {
	private static final Logger log = LogManager.getLogger(VesselController.class);

	private final TrackService trackService;
	private final RestService restService;
	
	public VesselController(TrackService trackService, RestService restService) {
		this.trackService = trackService;
		this.restService = restService;
	}

	@RequestMapping(
			value ="/vessels",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Track[] getVessels() {
		return restService.getRequestForVesselsPositions(Optional.empty());
	}

	@GetMapping("/vessels/{mmsi}")
	public String getVesselByName(@PathVariable Long mmsi, Model model) {
		log.info("Request mmsi: {}", mmsi);
		model.addAttribute("vessel", trackService.getVesselInfoByMMSI(mmsi));
		model.addAttribute("vesselHistory", trackService.getVesselHistoryByMMSI(mmsi));
		return "vessel";
	}
	
	@RequestMapping(
			value = "/vessel/history",
			method = RequestMethod.POST)
	public ResponseEntity<?> insertHistory(@RequestBody Track track) {
		trackService.insertHistory(track);
	    return ResponseEntity.ok().build(); 
	}
	
}
