package com.example.employeemanagement.entity.common;

import javax.persistence.Column;

public class CommonEntity {
    @Column(name = "isDeleted", nullable = false, columnDefinition = "0")
    private Integer isDeleted;
}
