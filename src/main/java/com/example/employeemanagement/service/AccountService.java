package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.object.Account;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;


public interface AccountService {

    public List<Account> getAll();

    public Optional<Account> getOne(Integer id);

    public Account addAccount(Account account);

    public Account updateAccount(Account account, Integer id);

    public Account deleteAccount(Integer id) throws ChangeSetPersister.NotFoundException;


}
