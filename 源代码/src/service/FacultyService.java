package service;

import entity.Faculty;

import java.util.List;

public interface FacultyService {

	/**
	 * 根据账户名查找
	 * @param name
	 * @return
	 */
	Faculty selectByName(String name);

	/**
	 * 更新密码
	 * @param pwd
	 * @return
	 */
	boolean updateByPwd(String pwd,String name);

	/**
	 * 更新全部
	 * @param faculty
	 * @return
	 */
	boolean update(Faculty faculty);


	List<Faculty> findAll();

	/**
	 * 按账户名字删除
	 * @param name
	 */
	boolean deleteByName(String name);

	/**
	 * 添加
	 * @param faculty
	 * @return
	 */
	boolean insert(Faculty faculty);

}
