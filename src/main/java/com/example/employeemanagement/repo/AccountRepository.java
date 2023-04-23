package com.example.employeemanagement.repo;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.object.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>, JpaSpecificationExecutor<Account> {

    Optional<Account> findAccountByUserName(String username);
    List<Account> findAllByUserNameIn(List<String> usernames);
}
