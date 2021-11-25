package com.cg.sprint.bus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.bus.model.Route;
import com.cg.sprint.bus.service.RouteService;

@RestController
public class RouteController implements IRouteController{
	
	private static final Logger LOG = LoggerFactory.getLogger(RouteController.class);
	
	@Autowired
	private RouteService routeService;

	@Override
	@PostMapping("/addRoute")
	public ResponseEntity<Route> addRoute(@RequestBody Route route) {
		LOG.info("addRoute Controller");
		Route r = routeService.addRoute(route);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Route has been added to the dataBase");
		ResponseEntity<Route> response = new ResponseEntity<Route>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/updateRoute")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) {
		LOG.info("updateBus Controller");
		Route r = routeService.updateRoute(route);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Route has been updated to the dataBase");
		ResponseEntity<Route> response = new ResponseEntity<Route>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@DeleteMapping("/deleteRoute/{routeId}")
	public ResponseEntity<Route> deleteroute(@PathVariable(name = "routeId") int routeId) {
		LOG.info("deleteRoute Controller");
		Route r = routeService.deleteRoute(routeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Route has been deleted from the dataBase");
		ResponseEntity<Route> response = new ResponseEntity<Route>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@GetMapping("/viewRoute/{routeId}")
	public ResponseEntity<Route> viewRoute(@PathVariable(name = "routeId") int routeId) {
		LOG.info("viewBus Controller");
		Route r = routeService.viewRoute(routeId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This is the available route");
		ResponseEntity<Route> response = new ResponseEntity<Route>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@GetMapping("/viewRoute")
	public List<Route> viewAll() {
		LOG.info("viewAllBus Controller");
		return routeService.viewAllRoute();
	}

}
