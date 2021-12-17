package com.cg.sprint.bus.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.bus.model.Bus;

public interface IBusController {

	public ResponseEntity<Bus> addBus(Bus bus);
	public ResponseEntity<Bus> updateBus(Bus bus);
	public ResponseEntity<Bus> deleteBus(int busId);
	public ResponseEntity<Bus> viewBus(int busId);
	public List<Bus> viewBusByType(String busType);
	public List<Bus> viewAllBus();
}
