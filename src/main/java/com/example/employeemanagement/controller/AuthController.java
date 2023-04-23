package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.auth.AuthInfoDTO;
import com.example.employeemanagement.entity.auth.LoginRequest;
import com.example.employeemanagement.entity.auth.RegisterRequest;
import com.example.employeemanagement.service.LoginRegisterService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value="api/v1/auth")
public class AuthController {
    private final LoginRegisterService loginRegisterService;

    public AuthController(LoginRegisterService loginRegisterService) {
        this.loginRegisterService = loginRegisterService;
    }


    @PostMapping(value="/login")
    public ResponseEntity<Optional<AuthInfoDTO>> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().body(loginRegisterService.login(loginRequest));
    }
    @PostMapping(value="/register")
    public ResponseEntity<Optional<AuthInfoDTO>> register(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok().body(loginRegisterService.register(registerRequest));
    }
}
