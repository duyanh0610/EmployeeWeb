package com.example.employeemanagement.entity.form.create;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class DepartmentCreateForm {
    @NotNull(message = "name can not be null")
    private String name;
    @PositiveOrZero(message = "total member can not be negative")
    private Integer totalMember;
    @NotNull(message = "type can not be null")
    private String type;
    private LocalDateTime createdDate;
    private List<String> accountUserName;

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

    public List<String> getAccountUserName() {
        return accountUserName;
    }

    public void setAccountUserName(List<String> userNames) {
        this.accountUserName = userNames;
    }
}
