package com.cg.sprint.bus.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.bus.model.Route;

public interface IRouteController {

	public ResponseEntity<Route> addRoute(Route route);
	public ResponseEntity<Route> updateRoute(Route route);
	public ResponseEntity<Route> deleteroute(int routeId);
	public ResponseEntity<Route> viewRoute(int routeId);
	public List<Route> viewAll();
}
