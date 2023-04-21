package com.example.employeemanagement.entity.auth;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;


    public LoginRequest username(String username) {
        this.username = username;
        return this;
    }

    public LoginRequest password(String password) {
        this.password = password;
        return this;
    }
}
