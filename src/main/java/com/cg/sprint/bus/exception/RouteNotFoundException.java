package com.cg.sprint.bus.exception;

public class RouteNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RouteNotFoundException() {
		super();
	}
	public RouteNotFoundException(String s) {
		super(s);
	}
}
