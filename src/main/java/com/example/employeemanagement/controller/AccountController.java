package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.service.AccountService;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<List<Account>> getAll () {
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Account>> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(accountService.getOne(id));
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        return ResponseEntity.status(201).body(accountService.addAccount(account));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account,
                                                 @PathVariable Integer id){
        return ResponseEntity.status(200).body(accountService.updateAccount(account,id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Account> deleteAccount(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.status(200).body(accountService.deleteAccount(id));
    }
}
