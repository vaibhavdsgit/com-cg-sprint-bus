package com.cg.sprint.bus.service;

import java.util.List;

import com.cg.sprint.bus.model.Route;

public interface IRouteService {

	public Route addRoute(Route route);
	public Route updateRoute(Route route);
	public Route deleteRoute(int routeId);
	public Route viewRoute(int routeId);
	public List<Route> viewAllRoute();
	
}
