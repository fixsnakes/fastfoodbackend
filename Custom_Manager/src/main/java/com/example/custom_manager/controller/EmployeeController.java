package com.example.custom_manager.controller;

import com.example.custom_manager.model.Employee;
import com.example.custom_manager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/find")
    public ResponseEntity<?> findEmployee(@RequestBody Employee employee){
        Optional<Employee> employeeOptional = employeeService.findEmployee(employee);
        if(employeeOptional.isPresent()){
            return ResponseEntity.ok(employeeOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee not found");
    }
}
