package com.cg.sprint.bus.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.bus.model.Reservation;

public interface IReservationController {

	public ResponseEntity<Reservation> addReservation(Reservation reservation);
	public ResponseEntity<Reservation> updateReservation(Reservation reservation);
	public ResponseEntity<Reservation> deleteReservation(int reservationId);
	public ResponseEntity<Reservation> viewReservation(int reservationId);
	public List<Reservation> viewAllReservation();
	public List<Reservation> getAllReservation(LocalDate date);
}
