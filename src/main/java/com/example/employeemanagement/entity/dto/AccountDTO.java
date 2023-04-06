package com.example.employeemanagement.entity.dto;

public class AccountDTO {
    private String userName;
    private String fullName;
    private String role;
    private String departmentName;

    public String getUsername() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public AccountDTO username(String userName) {
        this.userName = userName;
        return this;
    }

    public AccountDTO role(String role) {
        this.role = role;
        return this;
    }

    public AccountDTO departmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public AccountDTO fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }


}
