package com.example.custom_manager.model;
import jakarta.persistence.*;
import lombok.*;



@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private float price;

    @Column(name = "category")
    private String category;

    @Column(name = "description")
    private String description;

    @Column(name = "img_url")
    private String img_url;
}
