package com.cg.sprint.bus.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.sprint.bus.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer>{

	public abstract Admin findByAdminUsername(String adminUsername);
	public abstract Optional<Admin> findByAdminPassword(String password);
}
