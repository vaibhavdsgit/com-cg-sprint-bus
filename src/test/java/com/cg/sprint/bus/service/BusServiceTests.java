package com.cg.sprint.bus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint.bus.model.Bus;

@SpringBootTest
public class BusServiceTests {

	@Autowired
	private BusService busService;
	
	public void testDeleteBus() {
		Bus actual = busService.deleteBus(1);
		Bus expected = busService.viewBus(1);
		
		assertEquals(actual, expected);
	}
}
