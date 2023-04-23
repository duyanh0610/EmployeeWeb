package com.example.employeemanagement.service.impl;

import com.example.employeemanagement.entity.auth.AuthInfoDTO;
import com.example.employeemanagement.entity.auth.LoginRequest;
import com.example.employeemanagement.entity.auth.RegisterRequest;
import com.example.employeemanagement.entity.common.Constants;
import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.form.create.AccountCreateForm;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.exception.CustomException;
import com.example.employeemanagement.repo.AccountRepository;
import com.example.employeemanagement.service.AccountService;
import com.example.employeemanagement.service.LoginRegisterService;
import org.apache.logging.log4j.util.Strings;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
        if(Strings.isBlank(loginRequest.getUsername()) || Strings.isBlank(loginRequest.getPassword())){
            throw new CustomException("Username or password can not be blank!");
        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        if(!authentication.isAuthenticated()){
            throw new CustomException("Authentication failed!");
        }
        AuthInfoDTO authInfoDTO = modelMapper.map(accountService.getAccountByUsername(loginRequest.getUsername()),AuthInfoDTO.class);
        authInfoDTO.setPassword(null);
        return Optional.ofNullable(authInfoDTO);
    }

    @Override
    public Optional<AuthInfoDTO> register(RegisterRequest registerRequest) {
        if(Strings.isBlank(registerRequest.getUsername()) || Strings.isBlank(registerRequest.getPassword())){
            throw new CustomException("Username or password can not be blank!");
        }
        if(accountService.getAccountByUsername(registerRequest.getUsername()) != null){
            throw new CustomException("Username has already existed!");
        }
        Account account = new Account()
                .username(registerRequest.getUsername())
                .password(bCryptPasswordEncoder.encode(registerRequest.getPassword()))
                .lastName(registerRequest.getLastName())
                .firstName(registerRequest.getFirstName())
                .role(Constants.ROLE.EMPLOYEE);
        AuthInfoDTO authInfoDTO = modelMapper.map(account,AuthInfoDTO.class);
        accountService.createAccount(modelMapper.map(account, AccountCreateForm.class));
        authInfoDTO.setPassword(null);
        return Optional.ofNullable(authInfoDTO);
    }
}
