package com.cg.sprint.bus.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.sprint.bus.exception.AdminAlreadyExistsException;
import com.cg.sprint.bus.exception.LoginException;
import com.cg.sprint.bus.exception.UserNotFoundException;
import com.cg.sprint.bus.model.Admin;
import com.cg.sprint.bus.repository.AdminRepository;

@Service
public class AdminService implements IAdminService{

	private static final Logger LOG = LoggerFactory.getLogger(AdminService.class);
	public boolean adminIsLoggedIn;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin loginAdmin(Admin admin) {
//		LOG.info("Service loginUser");
//		Optional<Admin> optUser1 = adminRepository.findByAdminUsername(admin.getAdminUsername());
//		Optional<Admin> optUser2 = adminRepository.findByAdminPassword(admin.getAdminPassword());
		if(adminRepository.findByAdminUsername(admin.getAdminUsername()) != null) {
			LOG.info("Successfully logged in");
			adminIsLoggedIn = true;
			return adminRepository.findByAdminUsername(admin.getAdminUsername());
		}
		else {		
			LOG.info("User not found");
			throw new UserNotFoundException("Invalid Id or Password");
		}	
	}

	@Override
	public Admin addAdmin(Admin admin) {
		LOG.info("Service addAdmin");
//		System.out.println(admin.getAdminUsername());
//		System.out.println(adminRepository.findByAdminUsername(admin.getAdminUsername()));
		if(adminRepository.findByAdminUsername(admin.getAdminUsername()) != null) {
			LOG.info("AdminUserName already exists");
			throw new AdminAlreadyExistsException("Admin with " + admin.getAdminUsername() + " as username already exists");
		}
		else {		
			LOG.info("Admin added");
			return adminRepository.save(admin);
		}
	}

	@Override
	public Admin logoutAdmin(Admin admin) {
		LOG.info("Service adminLogout");
		if(adminIsLoggedIn == true) {
			LOG.info("You will be logged out");
			adminIsLoggedIn = false;
			return null;
		}
		else {
			LOG.warn("You need to login first");
			throw new LoginException("You need to admin login first");
		}
	}

}
