package com.cg.sprint.bus.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class BusControllerTests {
	
	@Autowired
	private BusController busController;
	
	@Test
	public void testViewBus() {
		HttpStatus expected = busController.viewBus(1).getStatusCode();
		HttpStatus actual = HttpStatus.OK;
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testViewBus1() {
		HttpStatus expected = busController.viewBus(2).getStatusCode();
		HttpStatus actual = HttpStatus.OK;
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testdeleteBus() {
		HttpStatus expected = busController.viewBus(1).getStatusCode();
		HttpStatus actual = HttpStatus.OK;
		
		assertEquals(expected, actual);	
	}
	
	@Test
	public void testdeleteBus2() {
		HttpStatus expected = busController.viewBus(2).getStatusCode();
		HttpStatus actual = HttpStatus.OK;
		
		assertEquals(expected, actual);	
	}
	

}
