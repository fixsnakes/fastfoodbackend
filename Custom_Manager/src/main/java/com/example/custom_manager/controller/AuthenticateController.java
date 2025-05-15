package com.example.custom_manager.controller;


import com.example.custom_manager.model.Customer;
import com.example.custom_manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/login")
public class AuthenticateController {

    @Autowired
    private CustomerService customerService;



    @PostMapping
    public ResponseEntity<?> login(@RequestBody Customer customer) {


        Customer customerauthen = customerService.authenticateUser(customer.getPhone(), customer.getPassword());
        if(customerauthen != null){

            return ResponseEntity.status(HttpStatus.OK).body(customerauthen);
        }

        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid phone or password");
        }


    }
}
