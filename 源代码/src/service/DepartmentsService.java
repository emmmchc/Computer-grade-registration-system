package service;

import entity.Departments;

import java.util.List;

public interface DepartmentsService {

    /**
     * 插入
     * @param departments
     * @return
     */
    int insert(Departments departments);

    /**
     * 查询全部
     * @return
     */
    List<Departments> findAll();
}
