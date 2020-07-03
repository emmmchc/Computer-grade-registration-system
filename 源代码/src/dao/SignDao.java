package dao;

import entity.Sign;

import java.util.List;

public interface SignDao {

    /**
     * 增、删、改
     * @param sql
     * @param params
     * @return
     */
    boolean doPstm(String sql, List<Object> params);


    /**
     * 按学号查询
     * @param signNumber
     * @return
     */
    Sign select(String signNumber);

    /**
     * 查询全部
     * @return
     */
    List<Sign> findAll();

    /**
     * 总记录数
     * @param sql
     * @return
     */
    int findtotalRecords(String sql);


    void confind(Sign sign);

    /**
     * 获取最后一条记录的id
     * @return
     */
    int selectLastId();

}
