package service.impl;

import dao.impl.FacultyDaoImpl;
import entity.Faculty;
import service.FacultyService;

import java.util.ArrayList;
import java.util.List;


public class FacultyServiceImpl implements FacultyService {

	@Override
	public Faculty selectByName(String name) {
		return new FacultyDaoImpl().selectByName(name);
	}

	@Override
	public boolean update(Faculty faculty) {
		String sql = "update faculty set department = ? , name = ? , pwd = ? where id = ?";
		List<Object> list = new ArrayList<>();
		list.add(faculty.getDepartment());
		list.add(faculty.getName());
		list.add(faculty.getPwd());
		list.add(faculty.getId());
		return new FacultyDaoImpl().doPstm(sql,list);
	}

	@Override
	public boolean updateByPwd(String pwd ,String name) {
		String sql = "update faculty set pwd = ? where name = ?";
		List<Object> list = new ArrayList<>();
		list.add(pwd);
		list.add(name);
		return new FacultyDaoImpl().doPstm(sql,list);
	}

	@Override
	public List<Faculty> findAll() {
		return new FacultyDaoImpl().findAll();
	}

	@Override
	public boolean deleteByName(String name) {
		String sql = "delete from faculty where name = ?";
		List<Object> list = new ArrayList<>();
		list.add(name);
		return new FacultyDaoImpl().doPstm(sql,list);
	}

	@Override
	public boolean insert(Faculty faculty) {
		String sql = "insert into faculty(department,name,pwd) value(?,?,?)";
		List<Object> list = new ArrayList<>();
		list.add(faculty.getDepartment());
		list.add(faculty.getName());
		list.add(faculty.getPwd());
		return new FacultyDaoImpl().doPstm(sql,list);
	}
}
