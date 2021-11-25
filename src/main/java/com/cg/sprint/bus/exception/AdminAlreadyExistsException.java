package com.cg.sprint.bus.exception;

public class AdminAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AdminAlreadyExistsException() {
		super();
	}
	public AdminAlreadyExistsException(String s) {
		super(s);
	}
}
