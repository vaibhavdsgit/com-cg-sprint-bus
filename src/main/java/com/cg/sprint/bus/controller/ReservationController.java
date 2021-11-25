package com.cg.sprint.bus.controller;

import java.time.LocalDate;
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
import com.cg.sprint.bus.model.Reservation;
import com.cg.sprint.bus.service.ReservationService;

@RestController
public class ReservationController implements IReservationController{
	
	private static final Logger LOG = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	private ReservationService revService;

	@Override
	@PostMapping("/addReservation")
	public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
		LOG.info("addReservation Controller");
		Reservation r = revService.addReservation(reservation);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Reservation has been added to the dataBase");
		ResponseEntity<Reservation> response = new ResponseEntity<Reservation>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/updateReservation")
	public ResponseEntity<Reservation> updateReservation(@RequestBody Reservation reservation) {
		LOG.info("updateReservation Controller");
		Reservation r = revService.updateReservation(reservation);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Reservation has been updated to the dataBase");
		ResponseEntity<Reservation> response = new ResponseEntity<Reservation>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/deleteReservation/{reservationId}")
	public ResponseEntity<Reservation> deleteReservation(@PathVariable(name = "reservationId") int reservationId) {
		LOG.info("updateReservation Controller");
		Reservation r = revService.deleteReservation(reservationId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Reservation has been deleted from the dataBase");
		ResponseEntity<Reservation> response = new ResponseEntity<Reservation>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@GetMapping("/viewReservation/{reservationId}")
	public ResponseEntity<Reservation> viewReservation(@PathVariable(name = "reservationId") int reservationId) {
		LOG.info("viewReservation Controller");
		Reservation r = revService.viewReservation(reservationId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The Reservation is available in the dataBase");
		ResponseEntity<Reservation> response = new ResponseEntity<Reservation>(r, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@GetMapping("/viewAllReservation")
	public List<Reservation> viewAllReservation() {
		LOG.info("viewAllReservation Controller");
		return revService.viewAllReservation();
	}

	@Override
	@GetMapping("/getAllReservation/{date}")
	public List<Reservation> getAllReservation(LocalDate date) {
		LOG.info("viewBusByType Controller");
		return revService.getAllReservation(date);
	}

}
