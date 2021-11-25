package com.cg.sprint.bus.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.bus.model.Bus;
import com.cg.sprint.bus.service.BusService;

@RestController
public class BusController implements IBusController{

	private static final Logger LOG = LoggerFactory.getLogger(BusController.class);
	
	@Autowired
	private BusService busService;
	
	@Override
	@PostMapping("/addBus")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) {
		LOG.info("addBus Controller");
		Bus b = busService.addBus(bus);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Bus has been added to the dataBase");
		ResponseEntity<Bus> response = new ResponseEntity<Bus>(b, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/updateBus")
	public ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
		LOG.info("updateBus Controller");
		Bus b = busService.updateBus(bus);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Bus has been updated to the dataBase");
		ResponseEntity<Bus> response = new ResponseEntity<Bus>(b, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/deleteBus/{busId}")
	public ResponseEntity<Bus> deletebus(@PathVariable(name = "busId") int busId) {
		LOG.info("deleteBus Controller");
		Bus b = busService.deleteBus(busId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Bus has been deleted from the dataBase");
		ResponseEntity<Bus> response = new ResponseEntity<Bus>(b, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@GetMapping("/viewBus/{busId}")
	public ResponseEntity<Bus> viewBus(@PathVariable(name = "busId") int busId) {
		LOG.info("viewBus Controller");
		Bus b = busService.viewBus(busId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This is the available bus");
		ResponseEntity<Bus> response = new ResponseEntity<Bus>(b, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@GetMapping("/viewBusByType/{busType}")
	public List<Bus> viewBusByType(@PathVariable(name = "busType") String busType) {
		LOG.info("viewBusByType Controller");
		return busService.viewBusByType(busType);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This is the available bus");
//		ResponseEntity<Bus> response = new ResponseEntity<Bus>(b, headers, HttpStatus.OK);
//		return response;
	}

	@Override
	@GetMapping()
	public List<Bus> viewAllBus() {
		LOG.info("viewAllBus Controller");
		return busService.viewAllBus();
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This is the available bus");
//		ResponseEntity<Bus> response = new ResponseEntity<Bus>(list, headers, HttpStatus.OK);
//		return response;
	}

	
}
