package com.cg.sprint.bus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.bus.model.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer>{

	public abstract List<Bus> findByBusType(String busType);
}
