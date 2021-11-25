package com.cg.sprint.bus.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.cg.sprint.bus.model.Admin;

public interface IAdminController {

	public abstract ResponseEntity<Admin> loginAdmin(Admin admin);
	public abstract ResponseEntity<Admin> addAdmin(Admin admin);
	public abstract ResponseEntity<Admin> logoutAdmin(Admin admin);
}
