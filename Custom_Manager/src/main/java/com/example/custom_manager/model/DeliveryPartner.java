package com.example.custom_manager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "delivery_partner")
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "delivery_partner_id")
    private long delivery_id;

    private String name_delivery;
}
