package service.impl;

import dao.impl.SignDaoImpl;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Override
    public boolean insert(Student student) {
        String sql = "insert into student(student_number, "
                + "student_name, student_sex, student_department, "
                + "student_phone, student_pwd, student_sign)"
                + "values(?, ?, ?, ?, ?, ?, ?)";
        List<Object> list = new ArrayList<>();
        list.add(student.getStudentNumber());
        list.add(student.getStudentName());
        list.add(student.getStudentSex());
        list.add(student.getStudentDepartment());
        list.add(student.getStudentPhone());
        list.add(student.getStudentPwd());
        list.add(student.getStudentSign());
        return new StudentDaoImpl().doPstm(sql,list);
    }

    @Override
    public boolean updatePwd(Student student) {
        String sql = "update student set student_pwd = ? where student_number = ?";
        List<Object> list = new ArrayList<>();
        list.add(student.getStudentPwd());
        list.add(student.getStudentNumber());
        return new StudentDaoImpl().doPstm(sql,list);
    }

    @Override
    public boolean updateSign(String sign,String signNumber) {
        String sql = "update student set student_sign = ? where student_number = ?";
        List<Object> list = new ArrayList<>();
        list.add(sign);
        list.add(signNumber);
        return new SignDaoImpl().doPstm(sql,list);
    }

    @Override
    public Student select(String studentName) {
        return new StudentDaoImpl().select(studentName);
    }

    @Override
    public Student selectByStudentNumber(String studentNumber) {
        return new StudentDaoImpl().selectByStudentNumber(studentNumber);
    }

    @Override
    public List<Student> findAll() {
        return new StudentDaoImpl().findAll();
    }

    @Override
    public boolean updateAllById(Student student) {
        String sql = "update student set student_number = ?, student_name = ?, "
                + "student_sex = ?, student_department = ?, student_phone = ?, "
                + "student_pwd = ?, student_sign = ? "
                + "where id = ?";
        List<Object> list = new ArrayList<>();
        list.add(student.getStudentNumber());
        list.add(student.getStudentName());
        list.add(student.getStudentSex());
        list.add(student.getStudentDepartment());
        list.add(student.getStudentPhone());
        list.add(student.getStudentPwd());
        list.add(student.getStudentSign());
        list.add(student.getId());
        return new SignDaoImpl().doPstm(sql,list);
    }

    @Override
    public boolean deleteByStudentNumber(String studentNumber) {
        String sql = "delete from student where student_number = ?";
        List<Object> list = new ArrayList<>();
        list.add(studentNumber);
        return new StudentDaoImpl().doPstm(sql,list);
    }
}
