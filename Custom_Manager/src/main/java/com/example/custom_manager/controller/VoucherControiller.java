package com.example.custom_manager.controller;


import com.example.custom_manager.model.Voucher;
import com.example.custom_manager.service.VoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vouchers")


public class VoucherControiller {

    @Autowired
    private VoucherService voucherService;

    @GetMapping("/{vouchercode}")
    public ResponseEntity<?> findByVoucherCode(@PathVariable("vouchercode") String vouchercode) {
        Voucher voucherfind = voucherService.findbyCode(vouchercode);


        if (voucherfind != null) {

            return ResponseEntity.status(HttpStatus.OK).body(voucherfind);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Voucher Not Found");


    }
}
