package dao.impl;

import dao.FacultyDao;
import entity.Faculty;
import util.DbPools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacultyDaoImpl implements FacultyDao {
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private Connection conn;
    public FacultyDaoImpl() {
    }


    public boolean doPstm(String sql, List<Object> params){
        System.out.println("sql:"+sql);
        boolean flag = false;
        int result = -1;
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            if(params != null && !params.isEmpty()){
                for(int i=0; i<params.size(); i++){
                    pstmt.setObject(i+1, params.get(i));
                    System.out.println("i:"+i+" "+params.get(i));
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
    public Faculty selectByName(String name) {
        String sql = "select * from faculty where name = ?";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Faculty faculty = new Faculty();
        try {
            if(resultSet.next()){
                faculty.setId(resultSet.getInt(1));
                faculty.setDepartment(resultSet.getString(2));
                faculty.setName(resultSet.getString(3));
                faculty.setPwd(resultSet.getString(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return faculty;
    }


    @Override
    public int update(Faculty faculty) {
        String sql = "update faculty set pwd = ? where id = ?";
        int result = 0;
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, faculty.getPwd());
            pstmt.setInt(2, faculty.getId());
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return result;
    }

    @Override
    public List<Faculty> findAll() {
        String sql = "select * from faculty";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Faculty> faculties = new ArrayList<>();
        try {
            while(resultSet.next()){
                Faculty faculty = new Faculty();
                faculty.setId(resultSet.getInt(1));
                faculty.setDepartment(resultSet.getString(2));
                faculty.setName(resultSet.getString(3));
                faculty.setPwd(resultSet.getString(4));
                faculties.add(faculty);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return faculties;
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
