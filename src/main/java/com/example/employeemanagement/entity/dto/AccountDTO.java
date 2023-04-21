package com.example.employeemanagement.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountDTO {

    private String username;
    @JsonIgnore
    private String password;
    private String fullName;
    private String role;
    @JsonProperty("department ID")
    private Integer departmentId;
    @JsonProperty("department name")
    private String departmentName;

    public AccountDTO(String username, String password, String fullName, String role, Integer departmentId, String departmentName) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public String getUsername() {
        return username;
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

    public void setUsername(String username) {
        this.username = username;
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


    public AccountDTO username(String username) {
        this.username = username;
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
