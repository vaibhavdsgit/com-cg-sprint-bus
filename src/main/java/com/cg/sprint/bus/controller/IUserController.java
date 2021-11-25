package com.cg.sprint.bus.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.bus.model.User;

public interface IUserController {

	public ResponseEntity<Optional<User>> loginUser(User user);
	public ResponseEntity<User> addUser(User user);
	public ResponseEntity<User> updateUser(User user);
	public ResponseEntity<User> deleteUser(int userId);
	public ResponseEntity<User> viewUser(int userId);
	public List<User> viewAllUsers();
}
