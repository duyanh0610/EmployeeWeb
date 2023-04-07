package com.example.employeemanagement.repo;

import com.example.employeemanagement.entity.object.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>, JpaSpecificationExecutor<Account> {

}
