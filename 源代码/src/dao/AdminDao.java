package dao;

import entity.Admin;

public interface AdminDao {
    /**
     * 根据用户名查询
     * @param name
     * @return
     */
    Admin selectByName(String name);

    /**
     * 更新密码
     * @param admin
     * @return
     */
    int update(Admin admin);
}
