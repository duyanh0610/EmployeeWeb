package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.object.Account;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Optional;


public interface AccountService {

    public List<AccountDTO> getAll();

    public Optional<AccountDTO> getOne(Integer id);

    public AccountDTO create(Account account);

    public AccountDTO update(Account account, Integer id) throws ChangeSetPersister.NotFoundException;

    public AccountDTO delete(Integer id) throws ChangeSetPersister.NotFoundException;


}
