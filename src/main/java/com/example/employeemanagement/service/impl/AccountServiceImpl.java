package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.repo.DepartmentRepository;
import com.example.employeemanagement.service.AccountService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final DepartmentRepository departmentRepository;

    public AccountServiceImpl(AccountRepository accountRepository, DepartmentRepository departmentRepository) {
        this.accountRepository = accountRepository;
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<AccountDTO> getAll() {
        List<AccountDTO> accounts = accountRepository.findAll()
                .stream()
                .map(account -> {
                    AccountDTO accountDTO = new AccountDTO()
                            .username(account.getUserName())
                            .fullName(account.getFullName())
                            .role(account.getRole())
                            .departmentName(account.getDepartment().getName());
                    return accountDTO;
                }).collect(Collectors.toList());
        return accounts;
    }

    @Override
    public Optional<AccountDTO> getOne(Integer id) {
        return accountRepository.findById(id).map(account -> {
            AccountDTO accountDTO = new AccountDTO()
                    .username(account.getUserName())
                    .fullName(account.getFullName())
                    .role(account.getRole())
                    .departmentName(account.getDepartment().getName());
            return accountDTO;
        });
    }

    @Override
    public AccountDTO create(Account account) {
//        Department department = departmentRepository.findById()
        accountRepository.save(account);

        return new AccountDTO()
                .username(account.getUserName())
                .fullName(account.getFullName())
                .role(account.getRole())
                .departmentName(account.getDepartment().getName());

    }

    @Override
    public AccountDTO update(Account account, Integer id) throws ChangeSetPersister.NotFoundException {
        return accountRepository.findById(id)
                .map(acc -> {
                    account.id(id);
                    accountRepository.save(account);

                    return new AccountDTO()
                            .username(account.getUserName())
                            .fullName(account.getFullName())
                            .role(account.getRole())
                            .departmentName(account.getDepartment().getName());
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public AccountDTO delete(Integer id) throws ChangeSetPersister.NotFoundException {
        return accountRepository.findById(id)
                .map(acc -> {
                    acc.id(id);
                    accountRepository.save(acc);
                    return new AccountDTO()
                            .username(acc.getUserName())
                            .fullName(acc.getFullName())
                            .role(acc.getRole())
                            .departmentName(acc.getDepartment().getName());
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
