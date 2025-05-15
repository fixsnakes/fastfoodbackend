package com.example.custom_manager.service;


import com.example.custom_manager.model.Product;
import com.example.custom_manager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


    //getallproduct
    public List<Product> getallProducts() {
        return productRepository.findAll();
    }
}
