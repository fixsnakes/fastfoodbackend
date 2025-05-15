package com.example.custom_manager.service;

import com.example.custom_manager.model.DeliveryPartner;
import com.example.custom_manager.repository.DeliveryPartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryPartnerService {
    @Autowired
    public DeliveryPartnerRepository deliveryPartnerRepository;

    public List<DeliveryPartner> getListPartners(){
        return deliveryPartnerRepository.findAll();
    }
}
