package service.impl;

import dao.impl.DepartmentsDaoImpl;
import entity.Departments;
import service.DepartmentsService;

import java.util.List;

public class DepartmentsServiceImpl implements DepartmentsService {
    @Override
    public int insert(Departments departments) {
        return new DepartmentsDaoImpl().insert(departments);
    }

    @Override
    public List<Departments> findAll() {
        return new DepartmentsDaoImpl().findAll();
    }
}
