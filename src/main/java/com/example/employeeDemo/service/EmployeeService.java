package com.example.employeeDemo.service;

import com.example.employeeDemo.model.Employee;
import com.example.employeeDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
//    public Employee getById(int age) {
//        return employeeRepository.findById(id);
//    }
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    public List<Employee> getByName(String name) {
     return employeeRepository.findByName(name);
    }
}
