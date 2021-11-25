package com.cg.sprint.bus.exception;

public class BusNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5566991935384425795L;

	public BusNotFoundException() {
		super();
	}
	public BusNotFoundException(String s) {
		super(s);
	}
}
