package com.example.employeemanagement.entity.error;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private String errorCode;
    private String errorMessage;
    private String errorStatus;

    public ErrorResponse errorCode(String errorCode) {
        this.errorCode = errorCode;
        return this;
    }
    public ErrorResponse errorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
    public ErrorResponse errorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
        return this;
    }
}
