package com.example.employeemanagement.entity.common;

public enum Role {
    ADMIN("admin"),EMPLOYEE("employee");

    private String role;
    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
