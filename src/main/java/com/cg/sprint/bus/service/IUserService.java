package com.cg.sprint.bus.service;

import java.util.List;
import java.util.Optional;

import com.cg.sprint.bus.model.User;

public interface IUserService {
	public abstract Optional<User> loginUser(User user);
	public abstract User addUser(User user);
	public abstract User updateUser(User user);
	public abstract User deleteUser(int userId);
	public abstract User viewUser(int userId);
	public abstract List<User> viewAllUsers();
}
