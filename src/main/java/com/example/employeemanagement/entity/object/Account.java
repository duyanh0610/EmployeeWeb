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
    private String userName;

    @Column(name = "password", unique = true, nullable = false, length = 50)
    private String password;

    @Column(name = "first_name", unique = false, nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", unique = false, nullable = false, length = 50)
    private String lastName;

    @Column(name = "role", columnDefinition = "employee", nullable = false)
//    @Enumerated(EnumType.STRING)
    private String role;

    @Column(name = "dob")
    private LocalDate dob;

    @Formula("concat(first_name, ' ', last_name)")
    private String fullName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id", nullable = false)
    private Department department;

    public Account() {
    }


    public Account id(Integer id) {
        this.id = id;
        return this;
    }

    public Account userName(String userName) {
        this.userName = userName;
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

    public Account departmentId(Department department) {
        this.department = department;
        return this;
    }

    public Account dob(LocalDate dob) {
        this.dob = dob;
        return this;
    }

    public Account fullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", role='" + role + '\'' +
                ", dob=" + dob +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
