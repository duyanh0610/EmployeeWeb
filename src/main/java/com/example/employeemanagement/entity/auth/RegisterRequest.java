package com.example.employeemanagement.entity.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;


    public RegisterRequest username(String username) {
        this.username = username;
        return this;
    }

    public RegisterRequest password(String password) {
        this.password = password;
        return this;
    }
}
