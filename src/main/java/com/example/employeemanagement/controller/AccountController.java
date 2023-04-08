package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.dto.AccountDTO;
import com.example.employeemanagement.entity.form.create.AccountCreateForm;
import com.example.employeemanagement.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping(value ="/api/v1/accounts")
@Validated
public class AccountController {
    private final Logger log =LoggerFactory.getLogger(AccountController.class);
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<Page<AccountDTO>> getAll (Pageable pageable) {
        log.info("GET: request list accounts");
        return ResponseEntity.ok().body(accountService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<AccountDTO>> getOne(@PathVariable Integer id) {
        log.info("GET: request an account with id {}", id );
        return ResponseEntity.status(200).body(accountService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<AccountDTO> addAccount(@RequestBody @Valid AccountCreateForm accountCreateForm) {
        log.info("POST: add an account with username {}", accountCreateForm.getUserName() );
        return ResponseEntity.status(201).body(accountService.createAccount(accountCreateForm));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody @Valid AccountCreateForm accountCreateForm,
                                                 @PathVariable Integer id) throws NotFoundException {
        log.info("PUT: update an account with id {}", id);
        return ResponseEntity.status(200).body(accountService.updateAccount(accountCreateForm,id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteAccount(@PathVariable Integer id) throws NotFoundException {
        log.info("DELETE: delete an account with id {}", id);
        accountService.deleteAccount(id);
    }

}
