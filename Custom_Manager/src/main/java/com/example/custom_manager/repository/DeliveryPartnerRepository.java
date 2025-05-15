package com.example.custom_manager.repository;

import com.example.custom_manager.model.DeliveryPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Long> {
}
