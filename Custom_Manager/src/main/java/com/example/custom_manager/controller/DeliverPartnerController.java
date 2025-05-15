package com.example.custom_manager.controller;


import com.example.custom_manager.service.DeliveryPartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partners")
public class DeliverPartnerController {

    @Autowired
    public DeliveryPartnerService deliveryPartnerService;

    @GetMapping
    public ResponseEntity<?> getListPartners(){
        return ResponseEntity.status(HttpStatus.OK).body(deliveryPartnerService.getListPartners());
    }
}
