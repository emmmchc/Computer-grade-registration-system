package dao.impl;

import dao.AdminDao;
import entity.Admin;
import util.DbPools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {

    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private Connection conn;
    public AdminDaoImpl(){
    }

    @Override
    public Admin selectByName(String name) {
        String sql = "select * from admin where name = ?";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Admin admin = new Admin();
        try {
            if(resultSet.next()){
                admin.setId(resultSet.getInt(1));
                admin.setName(resultSet.getString(2));
                admin.setPwd(resultSet.getString(3));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return admin;
    }


    @Override
    public int update(Admin admin) {
        String sql = "update admin set pwd = ? where id = ?";
        int result=0;
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,admin.getPwd());
            pstmt.setInt(2,admin.getId());
            result = pstmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return result;
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
