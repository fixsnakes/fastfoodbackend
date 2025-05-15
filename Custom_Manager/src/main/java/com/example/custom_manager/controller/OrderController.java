package com.example.custom_manager.controller;

import com.example.custom_manager.model.Order;
import com.example.custom_manager.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/createorder")
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody Order orderres){
        return ResponseEntity.status(HttpStatus.OK).body(orderService.placeOrder(orderres));
    }
}
