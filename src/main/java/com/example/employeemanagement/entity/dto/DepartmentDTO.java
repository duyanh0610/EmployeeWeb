package com.example.employeemanagement.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentDTO {
    private String name;
    private Integer totalMember;
    private String type;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdDate;

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalMember(Integer totalMember) {
        this.totalMember = totalMember;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

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
