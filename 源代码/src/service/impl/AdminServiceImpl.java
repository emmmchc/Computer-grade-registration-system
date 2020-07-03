package service.impl;

import dao.impl.AdminDaoImpl;
import entity.Admin;
import service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Override
	public int update(Admin admin) {
		return new AdminDaoImpl().update(admin);
	}

	@Override
	public Admin selectByName(String name) {
		return new AdminDaoImpl().selectByName(name);
	}
}
