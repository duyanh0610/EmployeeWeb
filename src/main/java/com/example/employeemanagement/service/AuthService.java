package com.example.employeemanagement.service;

import com.example.employeemanagement.entity.object.Account;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    Account getAccountByUsername(String username);
}
