package com.cg.sprint.bus.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "bus_table")
public class Bus implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int busId;
	
	@Column
	String busName;
	
	@Column
	String driverName;
	
	@Column
	String busType;
	
	@Column
	String routeFrom;
	
	@Column
	String routeTo;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	LocalTime arrivalTime;
	
	@Column
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
	LocalTime departureTime;
	
	@Column
	int seats;
	
	@Column
	int seatsAvailable;
	
	public Bus() {
		super();
	}

	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
			LocalTime arrivalTime, LocalTime departureTime, int seats, int seatsAvailable) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.seatsAvailable = seatsAvailable;
	}

	
//	public Bus(int busId, String busName, String driverName, String busType, String routeFrom, String routeTo,
//			LocalTime arrivalTime, LocalTime departureTime, int seats, int seatsAvailable, Route route) {
//		super();
//		this.busId = busId;
//		this.busName = busName;
//		this.driverName = driverName;
//		this.busType = busType;
//		this.routeFrom = routeFrom;
//		this.routeTo = routeTo;
//		this.arrivalTime = arrivalTime;
//		this.departureTime = departureTime;
//		this.seats = seats;
//		this.seatsAvailable = seatsAvailable;
//		this.route = route;
//	}

	public int getBusId() {
		return busId;
	}

	public void setBusId(int busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getRouteFrom() {
		return routeFrom;
	}

	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}

	public String getRouteTo() {
		return routeTo;
	}

	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

//	public Route getRoute() {
//		return route;
//	}
//
//	public void setRoute(Route route) {
//		this.route = route;
//	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", driverName=" + driverName + ", busType=" + busType
				+ ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", arrivalTime=" + arrivalTime
				+ ", departureTime=" + departureTime + ", seats=" + seats + ", seatsAvailable=" + seatsAvailable + "]";
	}

	
	
	
	
	
	
}
