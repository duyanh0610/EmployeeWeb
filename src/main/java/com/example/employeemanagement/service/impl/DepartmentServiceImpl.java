package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.repo.DepartmentRepository;
import com.example.employeemanagement.service.DepartmentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final AccountRepository accountRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, AccountRepository accountRepository) {
        this.departmentRepository = departmentRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public List<DepartmentDTO> getAll() {
        List<DepartmentDTO> departmentDTOS = departmentRepository.findAll()
                .stream()
                .map(department -> {
                    return new DepartmentDTO()
                            .name(department.getName())
                            .totalMember(department.getTotalMember())
                            .type(department.getType())
                            .createdDate(department.getCreateDate());
                }).collect(Collectors.toList());
        return departmentDTOS;
    }

    @Override
    public Optional<DepartmentDTO> getOne(Integer id) {
        return departmentRepository.findById(id).map(department -> {
            DepartmentDTO departmentDTO = new DepartmentDTO()
                    .name(department.getName())
                    .totalMember(department.getTotalMember())
                    .type(department.getType())
                    .createdDate(department.getCreateDate());
            return departmentDTO;
        });
    }

    @Override
    public DepartmentDTO create(Department department) {
        departmentRepository.save(department);
        return new  DepartmentDTO()
                .name(department.getName())
                .totalMember(department.getTotalMember())
                .type(department.getType())
                .createdDate(department.getCreateDate());
    }

    @Override
    public DepartmentDTO update(Department department, Integer id) throws ChangeSetPersister.NotFoundException {
        return departmentRepository.findById(id)
                .map(dept -> {
                    department.id(id);
                    departmentRepository.save(department);
                    return new DepartmentDTO()
                            .name(department.getName())
                            .totalMember(department.getTotalMember())
                            .type(department.getType())
                            .createdDate(department.getCreateDate());
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public DepartmentDTO delete(Integer id) throws ChangeSetPersister.NotFoundException {
        return departmentRepository.findById(id)
                .map(dept -> {
                    departmentRepository.deleteById(id);
                    return new DepartmentDTO()
                            .name(dept.getName())
                            .totalMember(dept.getTotalMember())
                            .type(dept.getType())
                            .createdDate(dept.getCreateDate());
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
