package com.ctm.vessel.tracker.system.model;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import com.ctm.vessel.tracker.system.ports.entity.Port;
import com.ctm.vessel.tracker.system.track.service.TrackService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class VesselPoint {

    @Autowired
    private TrackService trackService;
	
    public VesselPoint (TrackService trackService) {
	    	this.trackService = trackService;
    }
    
    private double y;
    private double x;
    private String name;
    private double destinationY;
    private double destinationX;
    private String shipType;
    private String destination;
    private String destinationPortname;
    private String destinationPortCountry;
    private long mmsi; 
    
    public VesselPoint(Track track, String shipType, TrackService serviceTrack) {
    	this.y = track.getGeometry().getCoordinates().get(0);
        this.x = track.getGeometry().getCoordinates().get(1);
        this.shipType = shipType;
        this.name = track.getName();
        this.destination = track.getDestination();
		this.mmsi = track.getMmsi();
		this.trackService = serviceTrack;
    }
    
    public VesselPoint initializeDestination() {
    	Optional<Port> port = Optional.empty();
    	 if(StringUtils.isNoneBlank(destination)) {
        	 port = trackService.findDestination(getDestination());
    	 }
    	 
    	 if(port.isPresent()) {
    		 this.destinationX = port.get().getLatitude();
    		 this.destinationY = port.get().getLongitude();
    		 this.destinationPortname = port.get().getPortname();
    		 this.destinationPortCountry = port.get().getCountry();
    	 } else {
    		 this.destinationX = x;
    		 this.destinationY = y;
    		 this.destinationPortname = "Unknown";
    		 this.destinationPortCountry = "Unknown";
    	 }
    	 return this;
    }

	
}