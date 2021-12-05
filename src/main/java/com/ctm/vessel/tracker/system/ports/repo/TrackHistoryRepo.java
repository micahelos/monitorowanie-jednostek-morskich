package com.ctm.vessel.tracker.system.ports.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ctm.vessel.tracker.system.historytracker.entity.TrackHistory;

public interface TrackHistoryRepo extends JpaRepository<TrackHistory, Long> {
	
	@Query("SELECT p FROM TrackHistory p WHERE mmsi = :mmsi ORDER BY timestamp desc")
	public List<TrackHistory> findByMMSI(Long mmsi);
	
    @Modifying
    @Transactional
	@Query(value = "INSERT INTO maritime.track_history(mmsi, destination, lat, lng, name, sog, timestamp) values (?1, ?2, ?3, ?4, ?5,?6,?7) ON conflict do nothing", nativeQuery = true)
	public void upsert(Long mmsi, String destination, double lat, double lng, String name, double sog, String timestamp);
}
