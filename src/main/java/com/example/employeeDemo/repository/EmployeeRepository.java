package com.example.employeeDemo.repository;

import com.example.employeeDemo.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
    List<Employee> findByName(String name);


}
