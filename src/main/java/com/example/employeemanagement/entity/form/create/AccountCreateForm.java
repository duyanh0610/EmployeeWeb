package com.example.employeemanagement.entity.form.create;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
public class AccountCreateForm {
    @NotNull(message = "username can not be null")
    private String userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
