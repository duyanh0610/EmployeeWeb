package com.example.employeemanagement.exception.errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String code;
    private int status;
    private String errorMessage;
    private String detailMessage;


    public ErrorResponse code(String code) {
        this.code = code;
        return this;
    }

    public ErrorResponse status(int status) {
        this.status = status;
        return this;
    }

    public ErrorResponse errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }

    public ErrorResponse detailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
        return this;
    }
}
