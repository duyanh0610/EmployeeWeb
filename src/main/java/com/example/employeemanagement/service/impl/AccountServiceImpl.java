package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.form.AccountCreateForm;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.repo.DepartmentRepository;
import com.example.employeemanagement.service.AccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public AccountServiceImpl(AccountRepository accountRepository, DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Page<AccountDTO> getAll(Pageable pageable) {
        Page<Account> accountPage = accountRepository.findAll(pageable);
        List<AccountDTO> accounts = accountPage.getContent()
                .stream()
                .map(account -> {
                    return modelMapper.map(account, AccountDTO.class);
//                    AccountDTO accountDTO = new AccountDTO()
//                            .userName(account.getUserName())
//                            .password(account.getPassword())
//                            .fullName(account.getFullName())
//                            .role(account.getRole())
//                            .departmentId(account.getDepartment().getId())
//                            .departmentName(account.getDepartment().getName());
//                    return accountDTO;
                }).collect(Collectors.toList());
        return new PageImpl<>(accounts, pageable, accountPage.getTotalElements());
    }

    @Override
    public Optional<AccountDTO> getOne(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            return account.map(acc -> {
                return modelMapper.map(acc, AccountDTO.class);
//                AccountDTO accountDTO = new AccountDTO()
//                        .userName(acc.getUserName())
//                        .password(acc.getPassword())
//                        .fullName(acc.getFullName())
//                        .role(acc.getRole())
//                        .departmentId(acc.getDepartment().getId())
//                        .departmentName(acc.getDepartment().getName());
//                return accountDTO;
            });
        } else {
            // xử lí exception ở đây
            return null;
        }
    }

    @Override
    public AccountDTO createAccount(AccountCreateForm accountCreateForm) {
        Optional<Department> department = departmentRepository.findById(accountCreateForm.getDepartmentId());
        Account account = modelMapper.map(accountCreateForm,Account.class).id(null);
        if (department.isPresent()) {
            account.department(department.get());
            accountRepository.save(account);
        } else {
            // xử lí exception ở đây
        }
        return modelMapper.map(account, AccountDTO.class);
    }

    @Override
    public AccountDTO updateAccount(AccountCreateForm accountCreateForm, Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        Optional<Department> department = departmentRepository.findById(accountCreateForm.getDepartmentId());
        if (account.isPresent()) {
            account.map(acc -> {
                if (department.isPresent()) {
                    acc = modelMapper.map(accountCreateForm,Account.class);
                    acc.id(id);
                } else {
                    // xử lí exception ở đây
                }
                accountRepository.save(acc);
                return modelMapper.map(acc, AccountDTO.class);
            });
        } else {
            // xử lí exception ở đây

        }
        return null;
    }

    @Override
    public void deleteAccount(Integer id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isPresent()) {
            accountRepository.deleteById(id);
        } else {

        }
    }
}
