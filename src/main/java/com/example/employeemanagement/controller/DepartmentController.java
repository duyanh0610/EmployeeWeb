package com.example.employeemanagement.controller;

import com.example.employeemanagement.entity.dto.DepartmentDTO;
import com.example.employeemanagement.entity.object.Account;
import com.example.employeemanagement.entity.object.Department;
import com.example.employeemanagement.service.AccountService;
import com.example.employeemanagement.service.DepartmentService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping()
    public ResponseEntity<List<DepartmentDTO>> getAll () {
        return ResponseEntity.ok().body(departmentService.getAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<DepartmentDTO>> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(departmentService.getOne(id));
    }

    @PostMapping()
    public ResponseEntity<DepartmentDTO> addAccount(@RequestBody Department department) {
        return ResponseEntity.status(201).body(departmentService.create(department));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> updateAccount(@RequestBody Department department,
                                                 @PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(200).body(departmentService.update(department,id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DepartmentDTO> deleteAccount(@PathVariable Integer id) throws ChangeSetPersister.NotFoundException {
        return ResponseEntity.status(200).body(departmentService.delete(id));
    }
}
