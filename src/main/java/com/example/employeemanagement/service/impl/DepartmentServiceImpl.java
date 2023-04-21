package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.form.create.DepartmentCreateForm;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.repo.DepartmentRepository;
import com.example.employeemanagement.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
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
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public Optional<DepartmentDTO> getOne(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if(department.isPresent()){
            return department.map(dept -> {
                return modelMapper.map(dept, DepartmentDTO.class).createdDate(dept.getCreatedDate());
            });
        } else {
            // xử lí exception ở đây
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public DepartmentDTO createDepartment(DepartmentCreateForm departmentCreateForm) {
        Department department = modelMapper.map(departmentCreateForm,Department.class);
        departmentRepository.save(department);

        List<String> accountUsername = departmentCreateForm.getAccountUsername();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        if(accountUsername!= null && accountUsername.size() > 0){
            for (String username: accountUsername) {
                Account account = accountRepository.findAccountByUserName(username);
                account.setDepartment(department);
                accountRepository.save(account);
                accountDTOS.add(modelMapper.map(account,AccountDTO.class));

            }
        }

        return modelMapper.map(department,DepartmentDTO.class).createdDate(department.getCreatedDate()).accounts(accountDTOS);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public DepartmentDTO updateDepartment(DepartmentCreateForm departmentCreateForm, Integer id) {
        Department department = departmentRepository.findById(id).get();
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentCreateForm.setCreatedDate(department.getCreatedDate());
        if (department != null) {
            department = modelMapper.map(departmentCreateForm,Department.class);
            department.id(id);

            departmentRepository.save(department);

            List<String> accountUsername = departmentCreateForm.getAccountUsername();
            List<AccountDTO> accountDTOS = new ArrayList<>();
            if(accountUsername!= null && accountUsername.size() > 0){
                for (String username: accountUsername) {
                    Account account = accountRepository.findAccountByUserName(username);
                    account.setDepartment(department);
                    accountRepository.save(account);
                    accountDTOS.add(modelMapper.map(account,AccountDTO.class));

                }
            }
            return modelMapper.map(department,DepartmentDTO.class).createdDate(department.getCreatedDate()).accounts(accountDTOS);

        } else {
            // xử lí exception ở đây
        }
        return null;
    }


    @Override
    @Transactional(rollbackFor = {Exception.class, Throwable.class})
    public void deleteDepartment(Integer id) {
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            departmentRepository.deleteById(id);
        } else {
            // xử lí exception ở đây
        }
    }
}
