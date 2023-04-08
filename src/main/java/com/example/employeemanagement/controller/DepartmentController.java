package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.form.create.DepartmentCreateForm;
import com.example.employeemanagement.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/departments")
@Validated
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
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentCreateForm departmentCreateForm) throws ChangeSetPersister.NotFoundException {
        log.info("POST: add a department with name {}", departmentCreateForm.getName() );
        return ResponseEntity.status(201).body(departmentService.createDepartment(departmentCreateForm));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody @Valid DepartmentCreateForm departmentCreateForm,
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
