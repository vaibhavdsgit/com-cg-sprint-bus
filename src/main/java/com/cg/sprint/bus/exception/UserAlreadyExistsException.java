package com.cg.sprint.bus.exception;

public class UserAlreadyExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException() {
		super();
	}
	public UserAlreadyExistsException(String s) {
		super(s);
	}
}
