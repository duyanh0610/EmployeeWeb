package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.form.create.AccountCreateForm;
import com.example.employeemanagement.entity.object.Account;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface AccountService extends UserDetailsService {

    public Page<AccountDTO> getAll(Pageable pageable);

    public Optional<AccountDTO> getOne(Integer id);

    public AccountDTO createAccount(AccountCreateForm accountCreateForm);

    public AccountDTO updateAccount(AccountCreateForm accountCreateForm, Integer id) throws ChangeSetPersister.NotFoundException;

    public void deleteAccount(Integer id) throws ChangeSetPersister.NotFoundException;

    Optional<AccountDTO> getAccountByUsername(String username);



}
