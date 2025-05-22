package com.example.custom_manager.service;

import com.example.custom_manager.model.Employee;
import com.example.custom_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> findEmployee(Employee employee) {
        return employeeRepository.findById(employee.getEmployee_id());
    }
}
