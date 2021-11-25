package com.cg.sprint.bus.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);
	
	@ExceptionHandler(BusAlreadyExistsException.class)
	public ResponseEntity<Object> handleBusAlreadyExistsException(){
		LOG.info("handleBusAlreadyExistsException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "The bus already exists in the database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<Object> BusNotFoundException(){
		LOG.info("handleBusNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Bus does not exist in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(ReservationNotFoundException.class)
	public ResponseEntity<Object> ReservationNotFoundException(){
		LOG.info("reservationNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Reservation does not exist in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<Object> UserAlreadyExistsException(){
		LOG.info("reservationNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This User already exist in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> UserNotFoundException(){
		LOG.info("reservationNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This UserName does not exist in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<Object> RouteNotFoundException(){
		LOG.info("routeNotFoundException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Route does not exist in database");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<Object> LoginException(){
		LOG.info("LoginException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "You are not logged in, execute 'Login' first");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	@ExceptionHandler(AdminAlreadyExistsException.class)
	public ResponseEntity<Object> AdminLoginException(){
		LOG.info("AdminLoginException");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin username already exists");
		return new ResponseEntity<Object>(null, headers, HttpStatus.METHOD_NOT_ALLOWED); 
	}
}
