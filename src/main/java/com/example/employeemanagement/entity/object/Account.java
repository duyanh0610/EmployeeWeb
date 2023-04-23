package com.example.employeemanagement.entity.object;

import com.example.employeemanagement.entity.common.Role;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "account")
public class Account  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", unique = true, nullable = false, length = 50)
    private String username;

    @Column(name = "password", unique = true, nullable = false, length = 50)
    private String password;

    @Column(name = "first_name", unique = false, nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", unique = false, nullable = false, length = 50)
    private String lastName;

    @Column(name = "role", columnDefinition = "employee", nullable = false)
    private String role;

//    @Column(name = "dob")
//    private LocalDate dob;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }


    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Account id(Integer id) {
        this.id = id;
        return this;
    }

    public Account username(String username) {
        this.username = username;
        return this;
    }

    public Account password(String password) {
        this.password = password;
        return this;
    }

    public Account firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Account lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Account role(String role) {
        this.role = role;
        return this;
    }

    public Account department(Department department) {
        this.department = department;
        return this;
    }


    public Account fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + username + '\'' +
                ", role='" + role + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
