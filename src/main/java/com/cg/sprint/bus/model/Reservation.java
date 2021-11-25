package com.cg.sprint.bus.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="reservation_table")
public class Reservation implements Serializable{

	private static final long serialVersionUID = 1L;

		//@Id
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int reservationId;
	    
		@Column
		private String reservationStatus;
		
		@Column
		private String reservationType;
		
		@Column
//		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
		private LocalDate reservationDate = LocalDate.now();
		
		@Column
//		@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
		private LocalTime reservationTime = LocalTime.now();
		
		@Column
		private String source;
		
		@Column
		private String destination;
		
		@OneToOne(cascade = {CascadeType.MERGE})
		@JoinColumn(name = "busId")
		private Bus bus;
		
		public Reservation() {
			super();
		}
		public Reservation(int reservationId, String reservationStatus, String reservationType,
				LocalDate reservationDate, LocalTime reservationTime, String source, String destination) {
			super();
			this.reservationId = reservationId;
			this.reservationStatus = reservationStatus;
			this.reservationType = reservationType;
			this.reservationDate = reservationDate;
			this.reservationTime = reservationTime;
			this.source = source;
			this.destination = destination;
		}
		public Reservation(int reservationId, String reservationStatus, String reservationType,
				LocalDate reservationDate, LocalTime reservationTime, String source, String destination, Bus bus) {
			super();
			this.reservationId = reservationId;
			this.reservationStatus = reservationStatus;
			this.reservationType = reservationType;
			this.reservationDate = reservationDate;
			this.reservationTime = reservationTime;
			this.source = source;
			this.destination = destination;
			this.bus = bus;
		}

		public int getReservationId() {
			return reservationId;
		}

		public void setReservationid(int reservationId) {
			this.reservationId = reservationId;
		}

		public String getReservationStatus() {
			return reservationStatus;
		}

		public void setReservationStatus(String reservationStatus) {
			this.reservationStatus = reservationStatus;
		}

		public String getReservationType() {
			return reservationType;
		}

		public void setReservationType(String reservationType) {
			this.reservationType = reservationType;
		}

		public LocalDate getReservationDate() {
			return reservationDate;
		}

		public void setReservationDate(LocalDate reservationDate) {
			this.reservationDate = reservationDate;
		}

		public LocalTime getReservationTime() {
			return reservationTime;
		}

		public void setReservationTime(LocalTime reservationTime) {
			this.reservationTime = reservationTime;
		}

		public String getSource() {
			return source;
		}

		public void setSource(String source) {
			this.source = source;
		}

		public String getDestination() {
			return destination;
		}

		public void setDestination(String destination) {
			this.destination = destination;
		}

		public Bus getBus() {
			return bus;
		}

		public void setBus(Bus bus) {
			this.bus = bus;
		}

		@Override
		public String toString() {
			return "Reservation [reservationId=" + reservationId + ", reservationStatus=" + reservationStatus
					+ ", reservationType=" + reservationType + ", reservationDate=" + reservationDate
					+ ", reservationTime=" + reservationTime + ", source=" + source + ", destination=" + destination
					+ ", bus=" + bus + "]";
		}

		
		
		
}
