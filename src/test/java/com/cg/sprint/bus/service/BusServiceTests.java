package com.cg.sprint.bus.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.sprint.bus.model.Bus;

@SpringBootTest
public class BusServiceTests {

	@Autowired
	private BusService busService;
	
	@Test
	public void testDeleteBus() {
		Bus actual = busService.deleteBus(1);
		Bus expected = busService.viewBus(1);
		System.out.println(actual);
		System.out.println(expected);
		assertEquals(actual, expected);
	}
	
	@Test
	public void testDeleteBus2() {
		Bus actual = busService.deleteBus(2);
		Bus expected = busService.viewBus(2);
		
		assertEquals(actual, expected);
	}
}
