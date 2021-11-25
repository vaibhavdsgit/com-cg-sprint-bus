package com.cg.sprint.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.sprint.bus.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public abstract Optional<User> findByUserName(String userName);
	public abstract Optional<User> findByPassword(String password);
}
