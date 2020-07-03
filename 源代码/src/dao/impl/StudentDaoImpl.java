package dao.impl;

import dao.StudentDao;
import entity.Student;
import util.DbPools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private Connection conn;
    public StudentDaoImpl(){
    }

    public boolean doPstm(String sql, List<Object> params){
        boolean flag = false;
        int result = -1;
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            if(params != null && !params.isEmpty()){
                for(int i=0; i<params.size(); i++){
                    pstmt.setObject(i+1, params.get(i));
                }
            }
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        flag = result > 0 ? true : false;
        release();
        return flag;
    }

    @Override
    public Student select(String studentName) {
        String sql = "select * from student where student_name = ?";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,studentName);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Student student = new Student();
        try {
            if(resultSet.next()){
                student.setId(resultSet.getInt(1));
                student.setStudentNumber(resultSet.getString(2));
                student.setStudentName(resultSet.getString(3));
                student.setStudentSex(resultSet.getString(4));
                student.setStudentDepartment(resultSet.getString(5));
                student.setStudentPhone(resultSet.getString(6));
                student.setStudentPwd(resultSet.getString(7));
                student.setStudentSign(resultSet.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return student;
    }

    @Override
    public Student selectByStudentNumber(String studentNumber) {
        String sql = "select * from student where student_number = ?";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,studentNumber);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Student student = new Student();
        try {
            if(resultSet.next()){
                student.setId(resultSet.getInt(1));
                student.setStudentNumber(resultSet.getString(2));
                student.setStudentName(resultSet.getString(3));
                student.setStudentSex(resultSet.getString(4));
                student.setStudentDepartment(resultSet.getString(5));
                student.setStudentPhone(resultSet.getString(6));
                student.setStudentPwd(resultSet.getString(7));
                student.setStudentSign(resultSet.getString(8));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return student;
    }

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Student> students = new ArrayList<>();
        try {
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setStudentNumber(resultSet.getString(2));
                student.setStudentName(resultSet.getString(3));
                student.setStudentSex(resultSet.getString(4));
                student.setStudentDepartment(resultSet.getString(5));
                student.setStudentPhone(resultSet.getString(6));
                student.setStudentPwd(resultSet.getString(7));
                student.setStudentSign(resultSet.getString(8));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return students;
    }

    //取总记录数
    @Override
    public int findtotalRecords(String sql) {
        //创建变量存取个数
        int count=0;
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                count=resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        release();
        return count;
    }


    public ArrayList<Student> getAllAuto(int startIndex,int pageSize,String sql){
        ArrayList<Student> list=new ArrayList<Student>();
        try{
            conn = DbPools.getConnection();
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1, startIndex);
            pstmt.setInt(2, pageSize);
            resultSet = pstmt.executeQuery();
            list=autogetAll(resultSet);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            release();
        }
        return list;
    }



    public ArrayList<Student> autogetAll(ResultSet rs) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            while(resultSet.next()){
                Student student = new Student();
                student.setId(resultSet.getInt(1));
                student.setStudentNumber(resultSet.getString(2));
                student.setStudentName(resultSet.getString(3));
                student.setStudentSex(resultSet.getString(4));
                student.setStudentDepartment(resultSet.getString(5));
                student.setStudentPhone(resultSet.getString(6));
                student.setStudentPwd(resultSet.getString(7));
                student.setStudentSign(resultSet.getString(8));
                students.add(student);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return students;

    }


    public List<Student> studentPage(int startIndex, int pageSize, String sql) throws Exception {;
        ArrayList<Student> list=null;
        list=getAllAuto(startIndex,pageSize,sql);
        return list;
    }





    /**
     * 释放数据库连接
     */
    public void release(){

        try{
            if(resultSet != null) resultSet.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
