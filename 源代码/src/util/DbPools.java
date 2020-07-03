package util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbPools {
    //创建成员变量
    private static DataSource ds=null;
    //加载配置文件
    static {
        try {
            Properties pro = new Properties();
            pro.load(DbPools.class.getClassLoader().getResourceAsStream("/druid.properties"));
            //获取dataSource连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception o){
            o.printStackTrace();
        }
    }
    /**
     * 获取连接对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    /**
     * 释放资源
     */
    public static void close(Statement stat,Connection conn){
        close(null,stat,conn);
    }
    public static void close(ResultSet res,Statement stat,Connection conn){
        if(res!=null){
            try {
                res.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 获取连接池
     */
    public static DataSource getDataSource(){
        return ds;
    }
}