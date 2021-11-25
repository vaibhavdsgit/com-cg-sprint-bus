package com.cg.sprint.bus.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "route_table")
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int routeId;
	
	@Column
	private String routeFrom;
	
	@Column
	private String routeTo;
	
	@Column
	private int distance;
	
	@OneToMany(targetEntity = Bus.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "BR_fk", referencedColumnName = "routeId")
	private List<Bus> bus;
	
	public Route() {
		super();
	}

	public Route(int routeId, String routeFrom, String routeTo, int distance) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
	}

	public Route(int routeId, String routeFrom, String routeTo, int distance, List<Bus> bus) {
		super();
		this.routeId = routeId;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.distance = distance;
		this.bus = bus;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
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

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public List<Bus> getBus() {
		return bus;
	}

	public void setBus(List<Bus> bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "Route [routeId=" + routeId + ", routeFrom=" + routeFrom + ", routeTo=" + routeTo + ", distance="
				+ distance + ", bus=" + bus + "]";
	}
	
}
