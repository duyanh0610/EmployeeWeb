package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.form.DepartmentCreateForm;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.service.AccountService;
import com.example.employeemanagement.service.DepartmentService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/departments")

public class DepartmentController {
    private final Logger log = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<Page<DepartmentDTO>> getAll(Pageable pageable) {
        log.info("GET: request list departments");

        return ResponseEntity.ok().body(departmentService.getAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DepartmentDTO>> getOne(@PathVariable Integer id) {
        log.info("GET: request a department with id {}", id );
        return ResponseEntity.status(200).body(departmentService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentCreateForm departmentCreateForm) throws ChangeSetPersister.NotFoundException {
        log.info("POST: add a department with name {}", departmentCreateForm.getName() );
        return ResponseEntity.status(201).body(departmentService.createDepartment(departmentCreateForm));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentCreateForm departmentCreateForm,
                                                 @PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        log.info("PUT: update a department with id {}", id);
        return ResponseEntity.status(200).body(departmentService.updateDepartment(departmentCreateForm,id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDepartment(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        log.info("DELETE: delete a department with id {}", id);
        departmentService.deleteDepartment(id);
    }
}
