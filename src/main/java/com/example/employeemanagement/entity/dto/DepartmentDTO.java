package com.example.employeemanagement.entity.dto;

import java.time.LocalDateTime;
import java.util.List;

public class DepartmentDTO {
    private String name;
    private Integer totalMember;
    private String type;
    private LocalDateTime createdDate;


    public String getName() {
        return name;
    }

    public Integer getTotalMember() {
        return totalMember;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public DepartmentDTO name(String name) {
        this.name = name;
        return this;
    }

    public DepartmentDTO totalMember(Integer totalMember) {
        this.totalMember = totalMember;
        return this;
    }

    public DepartmentDTO type(String type) {
        this.type = type;
        return this;
    }

    public DepartmentDTO createdDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }
}
