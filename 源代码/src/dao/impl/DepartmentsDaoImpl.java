package dao.impl;

import dao.DepartmentsDao;
import entity.Departments;
import util.DbPools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDaoImpl implements DepartmentsDao {
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private Connection conn;

    @Override
    public int insert(Departments departments) {
        String sql = "insert into departments(department) values(?)";

        int result=0;
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,departments.getDepartment());
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return result;
    }

    @Override
    public List<Departments> findAll() {
        String sql = "select * from departments";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Departments> departments = new ArrayList<>();
        try {
            while(resultSet.next()){
                Departments departments1 = new Departments();
                departments1.setDepartment(resultSet.getString(2));
                departments.add(departments1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return departments;
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
