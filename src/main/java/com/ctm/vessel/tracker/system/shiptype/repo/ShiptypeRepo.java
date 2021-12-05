package com.ctm.vessel.tracker.system.shiptype.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctm.vessel.tracker.system.shiptype.entity.Shiptype;

@Repository
public interface ShiptypeRepo extends JpaRepository<Shiptype, Long>  {
}
