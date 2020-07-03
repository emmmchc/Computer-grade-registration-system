package service;

import entity.Admin;

public interface AdminService {
	/**
	 *更新密码
	 * @param admin
	 * @return
	 */
	int update(Admin admin);
	
	/**
	 * 根据账户名查找
	 * @param name
	 * @return
	 */
	Admin selectByName(String name);
}
