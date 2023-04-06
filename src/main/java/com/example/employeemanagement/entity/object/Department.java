package com.example.employeemanagement.entity.object;

import com.example.employeemanagement.entity.common.DepartmentType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionImpl;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false, length = 50)
    private String name;

    @Column(name = "total_member")
    private Integer totalMember;

    @Column(name = "type", nullable = false)
//    @Enumerated(EnumType.STRING)
    private String type;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "department")
    private List<Account> accounts;

    public Department() {
    }

    public Integer getId() {
        return id;
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

    public LocalDateTime getCreateDate() {
        return createdDate;
    }

    @PrePersist
    public void prePersist(){
        if(createdDate == null) createdDate = LocalDateTime.now();
    }
//    @PreUpdate
//    public void preUpdate(){
//        createdDate = this.createdDate;
//    }

    public Department id(Integer id) {
        this.id = id;
        return this;
    }

    public Department name(String name) {
        this.name = name;
        return this;
    }

    public Department totalMember(Integer totalMember) {
        this.totalMember = totalMember;
        return this;
    }

    public Department type(String type) {
        this.type = type;
        return this;
    }

    public Department createDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Department account(List<Account> accounts) {
        this.accounts = accounts;
        return this;
    }

}
