package com.example.custom_manager.controller;


import com.example.custom_manager.model.Product;
import com.example.custom_manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    //getallproducts


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestParam(required = false) String name) {
        List<Product> products;
        if(name != null && !name.isEmpty()) {
            products = productService.findByNameContainingIgnoreCase(name);
        } else {
            products = productService.getallProducts();
        }
        return ResponseEntity.ok(products);
    }


}
