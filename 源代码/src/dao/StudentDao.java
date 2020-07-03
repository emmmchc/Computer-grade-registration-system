package dao;

import entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 根据学生姓名查找
     * @param studentName
     * @return
     */
    Student select(String studentName);

    /**
     * 根据学号查找
     * @param studentNumber
     * @return
     */
    Student selectByStudentNumber(String studentNumber);

    /**
     * 查询全部
     * @return
     */
    List<Student> findAll();


    /**
     * 添加、删除、改
     * @param sql
     * @param params
     * @return
     */
    boolean doPstm(String sql, List<Object> params);

    /**
     * 总记录数
     * @param sql
     * @return
     */
    int findtotalRecords(String sql);
}
