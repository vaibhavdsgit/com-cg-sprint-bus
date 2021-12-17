package com.cg.sprint.bus.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.sprint.bus.model.Admin;
import com.cg.sprint.bus.service.AdminService;

@RestController
@CrossOrigin(origins = "*")
public class AdminController implements IAdminController{
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private AdminService adminService;

	@Override
	@PostMapping("/loginAdmin")
	public ResponseEntity<Admin> loginAdmin(@RequestBody Admin admin) {
		LOG.info("loginUser Controller");
		Admin a = adminService.loginAdmin(admin);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin Login Successful");
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(a, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		LOG.info("addAdmin Controller");
		Admin a = adminService.addAdmin(admin);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin Added Successful");
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(a, headers, HttpStatus.OK);
		return response;
	}

	@Override
	@PostMapping("/logoutAdmin")
	public ResponseEntity<Admin> logoutAdmin(@RequestBody Admin admin) {
		LOG.info("logoutAdmin Controller");
		Admin a = adminService.logoutAdmin(admin);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Admin logged out Successful");
		ResponseEntity<Admin> response = new ResponseEntity<Admin>(a, headers, HttpStatus.OK);
		return response;
	}

}
