package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.service.AccountService;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<List<AccountDTO>> getAll () {
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<AccountDTO>> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(accountService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<AccountDTO> addAccount(@RequestBody Account account) {
        return ResponseEntity.status(201).body(accountService.create(account));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody Account account,
                                                 @PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.status(200).body(accountService.update(account,id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> deleteAccount(@PathVariable Integer id) throws NotFoundException {
        return ResponseEntity.status(200).body(accountService.delete(id));
    }
}
