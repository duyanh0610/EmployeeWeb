package com.example.employeemanagement.entity.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class RegisterRequest {
    @NotNull(message = "username can not be null")
    private String username;
    @NotNull(message = "password can not be null")
    private String password;
    @NotNull(message = "firstName can not be null")
    private String firstName;
    @NotNull(message = "lastName can not be null")
    private String lastName;
    //    @NotNull(message = "role can not be null")
    @Pattern(regexp = "ADMIN|EMPLOYEE|admin|employee", message = "Role must be employee or admin")
    private String role;
    @NotNull(message = "username can not be null")
    private Integer departmentId;


    public RegisterRequest username(String username) {
        this.username = username;
        return this;
    }

    public RegisterRequest password(String password) {
        this.password = password;
        return this;
    }

    public RegisterRequest firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public RegisterRequest lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RegisterRequest role(String role) {
        this.role = role;
        return this;
    }

    public RegisterRequest departmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }
}
