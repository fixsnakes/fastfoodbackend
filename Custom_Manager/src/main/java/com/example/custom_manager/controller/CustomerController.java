package com.example.custom_manager.controller;


import com.example.custom_manager.model.Customer;
import com.example.custom_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //findcustomer
    @PostMapping("/find")
    public ResponseEntity<?> findCustomer(@RequestBody Customer customer) {
        Optional<Customer> customerOptional = customerService.findCustomer(customer);
        if (customerOptional.isPresent()) {
            return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //getlistcustomer
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return  ResponseEntity.status(HttpStatus.OK).body(customerService.getlistCustomer());
    }


    //addcustomer
    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody Customer customerAdd) {
        Map<String, String> response = new HashMap<>();
        if (customerService.addCustomer(customerAdd)) {
            response.put("status", "success");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        else{
            response.put("status", "fail");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }

    }

    //updateCustomer
    @PutMapping()
    public ResponseEntity<?> updateCustomer( @RequestBody Customer customerupdate) {
        if(customerService.updateCustomer(customerupdate)) {
            return  ResponseEntity.status(HttpStatus.OK).body("Update Customer Success");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Update Customer Fail Not Found");
        }
    }

    //deleCustomer
    @DeleteMapping("/{customerid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerid) {
        if(customerService.deleteCustomer(customerid)) {
            return  ResponseEntity.status(HttpStatus.OK).body("Delete Customer Success");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Delete Customer Fail Not Found");
        }
    }
}
