package com.ctm.vessel.tracker.system.ports.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ctm.vessel.tracker.system.ports.entity.Port;

public interface PortsRepo extends JpaRepository<Port, String> {
	public List<Port> findByCode(String code);
	public List<Port> findByIso3(String iso3);
	
	@Query("SELECT p from Port p where lower(code) like %:destination% or lower(portname) like %:destination%")
	public List<Port> findDestination(String destination);
}
