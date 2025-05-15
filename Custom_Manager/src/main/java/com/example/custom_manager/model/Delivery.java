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
@Table(name = "delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "delivery_id")
    private long delivery_id;

    private long order_id;

    private String shipping_address;

    private long delivery_partner_id;


}
