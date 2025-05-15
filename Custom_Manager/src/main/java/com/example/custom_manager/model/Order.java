package com.example.custom_manager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.custom_manager.model.Product;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long order_id;

    private Long customer_id;
    private Date order_date;
    private String order_type;
    private String order_status;
    private float total_amount;
    private Long voucher_id;
    private String payment_method;
    private String shipping_address;
    private int deliverypartner_id;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

}
