package com.cg.sprint.bus.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.bus.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	public abstract List<Reservation> findByReservationDate(LocalDate localdate);
}
