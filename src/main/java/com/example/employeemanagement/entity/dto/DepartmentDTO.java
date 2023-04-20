package com.example.employeemanagement.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
    private String name;
    private Integer totalMember;
    private String type;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdDate;
    private List<AccountDTO> accounts;

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

    public List<AccountDTO> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
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

    public DepartmentDTO accounts(List<AccountDTO> accounts) {
        this.accounts = accounts;
        return this;
    }
}
