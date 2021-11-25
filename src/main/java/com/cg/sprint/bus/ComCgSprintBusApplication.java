package com.cg.sprint.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.sprint.bus.controller.BusController;

@SpringBootApplication
public class ComCgSprintBusApplication {

	public static void main(String[] args) {
		
		final Logger LOG = LoggerFactory.getLogger(BusController.class);
		
		LOG.info("Start");
		SpringApplication.run(ComCgSprintBusApplication.class, args);
		LOG.info("End");
	}

}
