package com.example.employeemanagement.repo;

import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
