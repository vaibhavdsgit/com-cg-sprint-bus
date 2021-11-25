package com.cg.sprint.bus.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bus.exception.LoginException;
import com.cg.sprint.bus.exception.ReservationNotFoundException;
import com.cg.sprint.bus.model.Reservation;
import com.cg.sprint.bus.repository.ReservationRepository;

@Service
public class ReservationService implements IReservationService{
	
	private static final Logger LOG = LoggerFactory.getLogger(ReservationService.class);
	
	@Autowired
	private ReservationRepository revRepository;
	
	@Autowired
	private AdminService adminService;

	@Override
	public Reservation addReservation(Reservation reservation) {
		if(adminService.adminIsLoggedIn == true) {
			LOG.info("Service addReservation");
			return revRepository.save(reservation);
		}
		else {
			throw new LoginException("Login into admin first");
		}
	}

	@Override
	public Reservation updateReservation(Reservation reservation) {
		if(adminService.adminIsLoggedIn == true) {
			LOG.info("Service updateReservation");
			if (revRepository.existsById(reservation.getReservationId())) {
				LOG.info("Reservation updated");
				return revRepository.save(reservation);
			}
			else {
				throw new ReservationNotFoundException("Reservation Not Found");
			}
		}
		else {
			throw new LoginException("Login into admin first");
		}
	}

	@Override
	public Reservation deleteReservation(int reservationId) {
		LOG.info("deleteReservationById");
		if(adminService.adminIsLoggedIn == true) {
			Optional<Reservation> revsOpt = revRepository.findById(reservationId);
			if (revsOpt.isPresent()) {
				LOG.info("Deleting Reservation");
				revRepository.deleteById(reservationId);
				return revsOpt.get();
			} else {
				LOG.info("reservation does not exist");
				throw new ReservationNotFoundException(reservationId + " this employee does not exist.");
			}
		}
		else {
			throw new LoginException("Login into admin first");
		}
	}

	@Override
	public Reservation viewReservation(int reservationId) {
		LOG.info("BusService viewBus");
		Optional<Reservation> busOpt = revRepository.findById(reservationId);
		if(busOpt.isPresent()) {
			LOG.info("Viewing Reservation");
			return busOpt.get();
		}
		else {
			LOG.info("reservation does not exist");
			throw new ReservationNotFoundException("Reservation with " + reservationId + "as id does not exist");
		}
	}

	@Override
	public List<Reservation> viewAllReservation() {
		LOG.info("Viewing all buses");
		return revRepository.findAll();
	}

	@Override
	public List<Reservation> getAllReservation(LocalDate date) {
		LOG.info("Viewing all buses based on date");
		return revRepository.findByReservationDate(date);
	}

}
