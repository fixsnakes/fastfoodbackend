package com.example.custom_manager.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "voucher_id")
    private Long voucher_id;

    private String code;
    private float discount;
    private String from_date;
    private String to_date;

}
