package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.object.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public List<Department> getAll();

    public Department getOne(Integer id);

    public Department addDepartment(Department account);

    public Department updateDepartment(Department account, Integer id);

    public Department deleteDepartment(Integer id);
}
