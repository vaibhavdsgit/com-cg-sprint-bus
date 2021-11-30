package com.cg.sprint.bus.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bus.exception.LoginException;
import com.cg.sprint.bus.exception.UserAlreadyExistsException;
import com.cg.sprint.bus.exception.UserNotFoundException;
import com.cg.sprint.bus.model.User;
import com.cg.sprint.bus.repository.UserRepository;

@Service
public class UserService implements IUserService{

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	public boolean isLoggedIn;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User loginUser(User user) {
		LOG.info("Service loginUser");
//		Optional<User> optUser1 = userRepository.findByUserName(user.getUserName());
//		Optional<User> optUser2 = userRepository.findByPassword(user.getPassword());
		if(userRepository.findByUserName(user.getUserName()) != null) {
			LOG.info("Successfully logged in");
			isLoggedIn = true;
			return userRepository.findByUserName(user.getUserName());
		}
		else {		
			LOG.info("User not found");
			throw new UserNotFoundException("Invalid Id or Password");
		}	
	}
	
	@Override
	public User addUser(User user) {
		LOG.info("addService addUser");
		System.out.println(userRepository.findByUserName(user.getUserName()));
		if(userRepository.findByUserName(user.getUserName()) != null) {
			LOG.info("UserName already exists");
			throw new UserAlreadyExistsException("User with " + user.getUserName() + " as username already exists");
		}
		else {		
			LOG.info("User added");
			return userRepository.save(user);
		}	
	}

	@Override
	public User updateUser(User user) {
		LOG.info("updateService updateUser");
		if(isLoggedIn == true) {
			if(userRepository.existsById(user.getUserId())) {
				LOG.info("user exists and will be updated");
				return userRepository.save(user);
			}
			else {
				LOG.info("user does not exists");
				throw new UserNotFoundException("User with " + user.getUserId() + " as Id does not exists");			
			}	
		}
		else {
			throw new LoginException("You need to login");
		}
	}

	@Override
	public User deleteUser(int userId) {
		LOG.info("deleteService deleteUser");
		if(isLoggedIn == true) {
			if(userRepository.existsById(userId)) {
				LOG.info("user will be deleted");
				userRepository.deleteById(userId);
				return null;
			}
			else {
				LOG.info("user does not exists");
				throw new UserNotFoundException("User with " + userId + " as Id does not exists");
			}
		}
		else {
			throw new LoginException("You need to login");
		}
	}

	@Override
	public User viewUser(int userId) {
		if(isLoggedIn == true) {
			LOG.info("Service viewUser");
			if(userRepository.existsById(userId)) {
				LOG.info("Viewing user");
	//			return userRepository.getById(userId);
				return userRepository.findById(userId).get();
			}
			else {
				LOG.info("User does not exist");
				throw new UserNotFoundException("User with " + userId + " does not exist");
			}
		}
		else {
			throw new LoginException("You need to login");
		}
	}

	@Override
	public List<User> viewAllUsers() {
		LOG.info("Viewing all users");
		if(isLoggedIn == true) {
			return userRepository.findAll();
		}
		else {
			throw new LoginException("You need to login");
		}
	}

	
}
