package service;

import entity.Student;

import java.util.List;

public interface StudentService {
	/**
	 * 插入
	 * @param student
	 * @return
	 */
	boolean insert(Student student);
	
	/**
	 * 更新密码
	 * @param student
	 * @return
	 */
	boolean updatePwd(Student student);


	/**
	 * 更新报名状态
	 * @param sign
	 * @param signNumber
	 * @return
	 */
	boolean updateSign(String sign,String signNumber);

	/**
	 * 根据学生姓名查找
	 * @param studentName
	 * @return
	 */
	public Student select(String studentName);
	
	/**
	 * 根据学号查找
	 * @param studentNumber
	 * @return
	 */
	public Student selectByStudentNumber(String studentNumber);


	/**
	 * 更新全部
	 * @param student
	 * @return
	 */
	boolean updateAllById(Student student);


	/**
	 * 查询全部
	 * @return
	 */
	List<Student> findAll();

	/**
	 * 根据学号删除
	 * @param studentNumber
	 * @return
	 */
	boolean deleteByStudentNumber(String studentNumber);

}
