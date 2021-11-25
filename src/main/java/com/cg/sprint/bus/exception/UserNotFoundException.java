package com.cg.sprint.bus.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super();
	}
	public UserNotFoundException(String s) {
		super(s);
	}
}
