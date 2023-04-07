package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.form.DepartmentCreateForm;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.repo.DepartmentRepository;
import com.example.employeemanagement.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;
    public DepartmentServiceImpl(DepartmentRepository departmentRepository, AccountRepository accountRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<DepartmentDTO> getAll(Pageable pageable) {
        Page<Department> departmentPage = departmentRepository.findAll(pageable);
        List<DepartmentDTO> departmentDTOS = departmentPage.getContent()
                .stream()
                .map(department -> {
                    return modelMapper.map(department,DepartmentDTO.class);

                }).collect(Collectors.toList());
        return new PageImpl<>(departmentDTOS, pageable, departmentPage.getTotalElements());
    }

    @Override
    public Optional<DepartmentDTO> getOne(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()){
            return department.map(dept -> {
                return modelMapper.map(dept, DepartmentDTO.class);
            });
        } else {
            // xử lí exception ở đây
            return null;
        }
    }

    @Override
    public DepartmentDTO createDepartment(DepartmentCreateForm departmentCreateForm) {
        Department department = modelMapper.map(departmentCreateForm,Department.class);
        departmentRepository.save(department);
        return modelMapper.map(department,DepartmentDTO.class);
    }

    @Override
    public DepartmentDTO updateDepartment(DepartmentCreateForm departmentCreateForm, Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        if (department.isPresent()) {
            department.map(dept -> {
                dept = modelMapper.map(departmentCreateForm,Department.class);
                dept.id(id);
                departmentRepository.save(dept);
                return modelMapper.map(dept,DepartmentDTO.class);
            });
        } else {
            // xử lí exception ở đây
        }
        return null;
    }


    @Override
    public void deleteDepartment(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            // xử lí exception ở đây
        }
    }
}
