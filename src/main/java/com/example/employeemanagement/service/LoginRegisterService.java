package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.auth.AuthInfoDTO;
import com.example.employeemanagement.entity.auth.LoginRequest;
import com.example.employeemanagement.entity.auth.RegisterRequest;

import java.util.Optional;

public interface LoginRegisterService {
    Optional<AuthInfoDTO> login(LoginRequest loginRequest);

    Optional<AuthInfoDTO> register(RegisterRequest registerRequest);
}
