package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.auth.AuthInfoDTO;
import com.example.employeemanagement.entity.auth.LoginRequest;
import com.example.employeemanagement.entity.auth.RegisterRequest;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.service.AccountService;
import com.example.employeemanagement.service.LoginRegisterService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class LoginRegisterServiceImpl implements LoginRegisterService {
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public LoginRegisterServiceImpl(AccountService accountService, AccountRepository accountRepository, AuthenticationManager authenticationManager, ModelMapper modelMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
        this.authenticationManager = authenticationManager;
        this.modelMapper = modelMapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<AuthInfoDTO> login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(null);
        return Optional.empty();
    }

    @Override
    public Optional<AuthInfoDTO> register(RegisterRequest registerRequest) {
        return Optional.empty();
    }
}
