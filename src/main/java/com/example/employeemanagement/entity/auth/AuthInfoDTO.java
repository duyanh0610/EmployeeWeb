package com.example.employeemanagement.entity.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthInfoDTO {
    private Integer id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String role;
    private String departmentName;


}
