package com.cg.sprint.bus.service;

import java.util.List;

import com.cg.sprint.bus.model.Bus;

public interface IBusService {

	public Bus addBus(Bus bus);
	public Bus updateBus(Bus bus);
	public Bus deleteBus(int busId);
	public Bus viewBus(int busId);
	public List<Bus> viewBusByType(String busType);
	public List<Bus> viewAllBus();
}
