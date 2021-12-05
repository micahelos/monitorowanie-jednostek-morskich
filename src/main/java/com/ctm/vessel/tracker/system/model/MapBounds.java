package com.ctm.vessel.tracker.system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class MapBounds {
	private Double minX;
	private Double maxX;
	private Double minY;
	private Double maxY;
	private Long zoom;
}
