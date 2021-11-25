package com.cg.sprint.bus.exception;

public class BusAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public BusAlreadyExistsException() {
		super();
	}
	public BusAlreadyExistsException(String s) {
		super(s);
	}
}
