package com.example.custom_manager.repository;

import com.example.custom_manager.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {
}
