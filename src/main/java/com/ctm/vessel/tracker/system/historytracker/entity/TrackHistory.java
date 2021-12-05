package com.ctm.vessel.tracker.system.historytracker.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.ctm.vessel.tracker.system.model.Track;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table	(name="track_history", 
		indexes = @Index(columnList = "MMSI"), 
		uniqueConstraints = @UniqueConstraint(columnNames = {"MMSI", "timestamp"}))
public class TrackHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Long MMSI;
	private String name;
	private double lat;
	private double lng;
	private double sog;
	private String timestamp;
	private String destination;
	
	public TrackHistory(Track track) {
		this.MMSI = Long.valueOf(track.getMmsi());
		this.name = track.getName();
		this.lat = track.getGeometry().getCoordinates().get(1);
		this.lng = track.getGeometry().getCoordinates().get(0);
		this.sog = track.getSog();
		this.timestamp = track.getTimeStamp();
		this.destination = track.getDestination();
	}
	public TrackHistory() {
		super();
	}
	
}
