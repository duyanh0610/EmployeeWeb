package com.example.employeemanagement.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String userName;
    @JsonIgnore
    private String password;
    private String fullName;
    private String role;
    @JsonProperty("department ID")
    private Integer departmentId;
    @JsonProperty("department name")
    private String departmentName;

    public AccountDTO(String userName, String password, String fullName, String role, Integer departmentId, String departmentName) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    public AccountDTO userName(String userName) {
        this.userName = userName;
        return this;
    }

    public AccountDTO password(String password) {
        this.password = password;
        return this;
    }

    public AccountDTO fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public AccountDTO role(String role) {
        this.role = role;
        return this;
    }

    public AccountDTO departmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public AccountDTO departmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }
}
