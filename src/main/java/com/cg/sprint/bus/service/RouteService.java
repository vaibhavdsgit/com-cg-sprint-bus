package com.cg.sprint.bus.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bus.exception.LoginException;
import com.cg.sprint.bus.exception.RouteNotFoundException;
import com.cg.sprint.bus.model.Route;
import com.cg.sprint.bus.repository.RouteRepository;

@Service
public class RouteService implements IRouteService{
	
	private static final Logger LOG = LoggerFactory.getLogger(RouteService.class);
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private AdminService adminService;

	@Override
	public Route addRoute(Route route) {
		if(adminService.adminIsLoggedIn == true) {
			LOG.info("RouteService addRoute");
			return routeRepository.save(route);
		}
		else {
			throw new LoginException("You need to admin login first");
		}
	}

	@Override
	public Route updateRoute(Route route) {
		LOG.info("RouteService addRoute");
		if(adminService.adminIsLoggedIn == true) {
			if(routeRepository.existsById(route.getRouteId())) {
				LOG.info("Route exists and will be updated");
				return routeRepository.save(route);
			}
			else {
				LOG.info("Route does not exist");
				throw new RouteNotFoundException("Route with " + route.getRouteId() + "as Id does not exist");
			}
		}
		else {
			throw new LoginException("You need to admin login first");
		}
	}

	@Override
	public Route deleteRoute(int routeId) {
		LOG.info("RouteService addRoute");
		if(adminService.adminIsLoggedIn == true) {
			Optional<Route> routeOpt = routeRepository.findById(routeId);
			if(routeOpt.isPresent()) {
				LOG.info("Route will be deleted");
				routeRepository.deleteById(routeId);
				return routeOpt.get();
			}
			else {
				LOG.info("Route does not exist");
				throw new RouteNotFoundException("Route with " + routeId + " does not exist");
			}
		}
		else {
			throw new LoginException("You need to admin login first");
		}
	}

	@Override
	public Route viewRoute(int routeId) {
		LOG.info("RouteService addRoute");
		Optional<Route> routeOpt = routeRepository.findById(routeId);
		if(routeOpt.isPresent()) {
			LOG.info("Viewing Route");
			return routeOpt.get();
		}
		else {
			LOG.info("Route does not exist");
			throw new RouteNotFoundException("Route with " + routeId + " does not exist");
		}
	}

	@Override
	public List<Route> viewAllRoute() {
		LOG.info("Viewing all Routes");
		return routeRepository.findAll();
	}

}
