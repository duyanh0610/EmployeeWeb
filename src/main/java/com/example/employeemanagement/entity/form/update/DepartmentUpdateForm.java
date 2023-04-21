package com.example.employeemanagement.entity.form.update;

import java.time.LocalDateTime;
import java.util.List;

public class DepartmentUpdateForm {
    private String name;
    private Integer totalMember;
    private String type;
    private LocalDateTime createdDate;
    private List<String> accountUsername;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalMember() {
        return totalMember;
    }

    public void setTotalMember(Integer totalMember) {
        this.totalMember = totalMember;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<String> getAccountUsername() {
        return accountUsername;
    }

    public void setAccountUserName(List<String> userNames) {
        this.accountUsername = userNames;
    }
}
