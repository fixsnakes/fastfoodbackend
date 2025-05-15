package com.example.custom_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.custom_manager.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
