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
@Table(name = "order_detail")

public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "order_detail_id")
    private Long order_detail_id;

    private Long order_id;
    private Long product_id;
    private int quantity;
    private float price;


}
