package com.example.custom_manager.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "customer_id")
    private long customer_id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name ="phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name ="password")
    private String password;

}
