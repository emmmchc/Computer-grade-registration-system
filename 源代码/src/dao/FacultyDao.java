package dao;

import entity.Faculty;

import java.util.List;

public interface FacultyDao {
    /**
     * 根据账户名查询
     * @param name
     * @return
     */
    Faculty selectByName(String name);

    /**
     * 更新密码
     * @param faculty
     * @return
     */
    int update(Faculty faculty);

    List<Faculty> findAll();

    /**
     * 增、删、改
     * @param sql
     * @param params
     * @return
     */
    boolean doPstm(String sql, List<Object> params);
}
