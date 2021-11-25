package com.cg.sprint.bus.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.sprint.bus.model.Reservation;

public interface IReservationService {

	public Reservation addReservation(Reservation reservation);
	public Reservation updateReservation(Reservation reservation);
	public Reservation deleteReservation(int reservationId);
	public Reservation viewReservation(int reservationId);
	public List<Reservation> viewAllReservation();
	public List<Reservation> getAllReservation(LocalDate date);
}
