package com.example.employeemanagement.exception.errors;

public class UsernameExistException extends RuntimeException{
    public UsernameExistException(String message) {
        super(message);
    }
}
