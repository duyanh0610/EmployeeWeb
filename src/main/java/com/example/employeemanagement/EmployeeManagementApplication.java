package com.example.employeemanagement;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        System.out.println("Current time " + LocalDateTime.now());
        ApplicationContext context = SpringApplication.run(EmployeeManagementApplication.class, args);
    }

}
