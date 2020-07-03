package dao.impl;

import dao.SignDao;
import entity.Sign;
import util.DbPools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SignDaoImpl implements SignDao {
    private PreparedStatement pstmt;
    private ResultSet resultSet;
    private Connection conn;


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
    public Sign select(String signNumber) {
        String sql = "select * from sign where sign_number = ?";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,signNumber);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Sign sign = new Sign();
        try {
            if(resultSet.next()){
                sign.setId(resultSet.getInt(1));
                sign.setSignNumber(resultSet.getString(2));
                sign.setSignName(resultSet.getString(3));
                sign.setSignSex(resultSet.getString(4));
                sign.setSignIdNumber(resultSet.getString(5));
                sign.setSignDepartment(resultSet.getString(6));
                sign.setSignSite(resultSet.getString(7));
                sign.setSignRoom(resultSet.getString(8));
                sign.setSignSeat(resultSet.getString(9));
                sign.setSignExamNumber(resultSet.getString(10));
                sign.setSignLevel(resultSet.getString(11));
                sign.setSignSubject(resultSet.getString(12));
                sign.setSignPhone(resultSet.getString(13));
                sign.setSignPic(resultSet.getString(14));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return sign;
    }


    @Override
    public List<Sign> findAll() {
        String sql = "select * from sign";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Sign> signs = new ArrayList<>();
        try {
            while(resultSet.next()){
                Sign sign = new Sign();
                sign.setId(resultSet.getInt(1));
                sign.setSignNumber(resultSet.getString(2));
                sign.setSignName(resultSet.getString(3));
                sign.setSignSex(resultSet.getString(4));
                sign.setSignIdNumber(resultSet.getString(5));
                sign.setSignDepartment(resultSet.getString(6));
                sign.setSignSite(resultSet.getString(7));
                sign.setSignRoom(resultSet.getString(8));
                sign.setSignSeat(resultSet.getString(9));
                sign.setSignExamNumber(resultSet.getString(10));
                sign.setSignLevel(resultSet.getString(11));
                sign.setSignSubject(resultSet.getString(12));
                sign.setSignPhone(resultSet.getString(13));
                sign.setSignPic(resultSet.getString(14));
                signs.add(sign);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return signs;
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

    public ArrayList<Sign> getAllAuto(int startIndex,int pageSize,String sql){
        ArrayList<Sign> list=new ArrayList<Sign>();
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

    public ArrayList<Sign> autogetAll(ResultSet rs) {
        ArrayList<Sign> signs = new ArrayList<>();
        try {
            while(resultSet.next()){
                Sign sign = new Sign();
                sign.setId(resultSet.getInt(1));
                sign.setSignNumber(resultSet.getString(2));
                sign.setSignName(resultSet.getString(3));
                sign.setSignSex(resultSet.getString(4));
                sign.setSignIdNumber(resultSet.getString(5));
                sign.setSignDepartment(resultSet.getString(6));
                sign.setSignSite(resultSet.getString(7));
                sign.setSignRoom(resultSet.getString(8));
                sign.setSignSeat(resultSet.getString(9));
                sign.setSignExamNumber(resultSet.getString(10));
                sign.setSignLevel(resultSet.getString(11));
                sign.setSignSubject(resultSet.getString(12));
                sign.setSignPhone(resultSet.getString(13));
                sign.setSignPic(resultSet.getString(14));
                signs.add(sign);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return signs;
    }

    public List<Sign> signPage(int startIndex, int pageSize,String sql) throws Exception {;
        ArrayList<Sign> list=null;
        list=getAllAuto(startIndex,pageSize,sql);
        return list;
    }


    @Override
    public void confind(Sign sign){
        //清空查询表
        doPstm("delete from sign2",null);

        String sql = "select * from sign where 1=1 ";
        List<Object> list = new ArrayList<Object>();
        if(sign.getSignName()!=null) {
            sql += " and sign_name like ?";
            list.add("%"+sign.getSignName()+"%");
        }
        if(sign.getSignNumber()!=null) {
            sql += " and sign_number like ?";
            list.add("%"+sign.getSignNumber()+"%");
        }
        sql = "insert into sign2 "+ sql;
        doPstm(sql,list);
        release();
    }


    @Override
    public int selectLastId() {
        String sql = "select max(id) from sign";
        try {
            conn = DbPools.getConnection();
            pstmt = conn.prepareStatement(sql);
            resultSet = pstmt.executeQuery();;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        int id = 0;
        try {
            if(resultSet.next()){
                id = resultSet.getInt(1);
                System.out.println("id:" + id);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        release();
        return id;
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


