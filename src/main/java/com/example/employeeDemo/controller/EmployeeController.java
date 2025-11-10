package com.example.employeeDemo.controller;

import com.example.employeeDemo.model.Employee;
import com.example.employeeDemo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private View error;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Value("${app.message}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return message;
    }

    // create
   @PostMapping("/employee")
    public org.springframework.http.ResponseEntity<java.util.Map<String,Object>> save(@Valid @RequestBody Employee employee) {
        Employee saved = employeeService.save(employee);
        java.util.Map<String,Object> body = new java.util.HashMap<>();
//        body.put("name cannot be empty");
       log.info("saved employee : {}", employee.getName());
        body.put("message", "Employee created successfully: " + saved.getName());
        body.put("employee", saved);
        return new org.springframework.http.ResponseEntity<>(body, org.springframework.http.HttpStatus.CREATED);
    }


    // find by name
    @GetMapping("/employee/{name}")
    public List<Employee> getByName(@PathVariable String name) {
        return employeeService.getByName(name);
    }

    // list all
    @GetMapping("/employees")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

}
