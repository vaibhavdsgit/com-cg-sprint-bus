package com.cg.sprint.bus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.bus.model.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{
	
}
