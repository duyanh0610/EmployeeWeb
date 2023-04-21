package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.exception.CustomException;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AuthServiceImpl(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Account getAccountByUsername(String username) {
        return accountRepository.findAccountByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username == null){
            throw new CustomException("username not valid");
        }
        Account account = accountRepository.findAccountByUserName(username);
        if(account == null){
            throw new UsernameNotFoundException(username);
        }
        return new User(
                account.getUserName(),
                account.getPassword(),
                Collections.emptyList()
        );

     }
}
