package com.example.employeemanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String timeStamp;
    private String code;
    private int status;
    private Object errors;
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

    public ErrorResponse errors(Object errors) {
        this.errors = errors;
        return this;
    }

    public ErrorResponse timeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
        return this;
    }


}
