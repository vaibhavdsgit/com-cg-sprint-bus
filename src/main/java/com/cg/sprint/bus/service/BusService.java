package com.cg.sprint.bus.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bus.exception.BusNotFoundException;
import com.cg.sprint.bus.model.Bus;
import com.cg.sprint.bus.repository.BusRepository;

@Service
public class BusService implements IBusService{
	
	private static final Logger LOG = LoggerFactory.getLogger(BusService.class);
	
	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus addBus(Bus bus) {
		LOG.info("BusService addBus");
		return busRepository.save(bus);
	}

	@Override
	public Bus updateBus(Bus bus) {
		LOG.info("BusService addBus");
		if(busRepository.existsById(bus.getBusId())) {
			LOG.info("Bus exists and will be updated");
			return busRepository.save(bus);
		}
		else {
			LOG.info("Bus does not exist");
			throw new BusNotFoundException("Bus with " + bus.getBusId() + "as Id does not exist");
		}
	}

	@Override
	public Bus deleteBus(int busId) {
		LOG.info("BusService addBus");
		Optional<Bus> busOpt = busRepository.findById(busId);
		if(busOpt.isPresent()) {
			LOG.info("Bus will be deleted");
			busRepository.deleteById(busId);
			return busOpt.get();
		}
		else {
			LOG.info("Bus does not exist");
			throw new BusNotFoundException("Bus with " + busId + " does not exist");
		}
	}

	@Override
	public Bus viewBus(int busId) {
		LOG.info("BusService viewBus");
		Optional<Bus> busOpt = busRepository.findById(busId);
		if(busOpt.isPresent()) {
			LOG.info("Viewing bus");
			return busOpt.get();
		}
		else {
			LOG.info("Bus does not exist");
			throw new BusNotFoundException("Bus with " + busId + " does not exist");
		}
	}

	@Override
	public List<Bus> viewBusByType(String busType) {
		LOG.info("viewBusByType Service");
		return busRepository.findByBusType(busType);
	}

	@Override
	public List<Bus> viewAllBus() {
		LOG.info("Viewing all buses");
		return busRepository.findAll();
	}

	
}
