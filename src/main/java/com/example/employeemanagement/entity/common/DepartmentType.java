package com.example.employeemanagement.entity.common;

public enum DepartmentType {
    DEVELOPER("Dev"),
    TESTER("Test"),
    SCRUM_MASTER("ScumMaster"),
    PROJECT_MANAGER("PM");


    private String type;

    DepartmentType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
