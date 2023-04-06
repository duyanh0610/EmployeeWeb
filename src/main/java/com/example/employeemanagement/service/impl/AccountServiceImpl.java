package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.service.AccountService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> getAll() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public Optional<Account> getOne(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account addAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account, Integer id) {
        return null;
    }

    @Override
    public Account deleteAccount(Integer id) throws ChangeSetPersister.NotFoundException {
        return getOne(id)
                .map(account -> {
                    account.id(id);
                    accountRepository.delete(account);
                    return account;
                })
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
