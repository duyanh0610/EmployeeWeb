package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.form.create.DepartmentCreateForm;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface DepartmentService {
    public Page<DepartmentDTO> getAll(Pageable pageable);

    public Optional<DepartmentDTO> getOne(Integer id);

    public DepartmentDTO createDepartment(DepartmentCreateForm departmentCreateForm);

    public DepartmentDTO updateDepartment(DepartmentCreateForm departmentCreateForm, Integer id) throws ChangeSetPersister.NotFoundException;

    public void deleteDepartment(Integer id) throws ChangeSetPersister.NotFoundException;
}
