package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface DepartmentService {
    public List<DepartmentDTO> getAll();

    public Optional<DepartmentDTO> getOne(Integer id);

    public DepartmentDTO create(Department department);

    public DepartmentDTO update(Department department, Integer id) throws ChangeSetPersister.NotFoundException;

    public DepartmentDTO delete(Integer id) throws ChangeSetPersister.NotFoundException;
}
