package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.auth.AuthInfoDTO;
import com.example.employeemanagement.entity.auth.LoginRequest;
import com.example.employeemanagement.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value="api/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping(value="/login")
    public ResponseEntity<Optional<AuthInfoDTO>> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok().body(null);
    }


}
