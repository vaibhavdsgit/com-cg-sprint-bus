package com.cg.sprint.bus.service;

import java.util.Optional;

import com.cg.sprint.bus.model.Admin;

public interface IAdminService {

	public abstract Admin loginAdmin(Admin admin);
	public abstract Admin addAdmin(Admin admin);
	public abstract Admin logoutAdmin(Admin admin);

}
