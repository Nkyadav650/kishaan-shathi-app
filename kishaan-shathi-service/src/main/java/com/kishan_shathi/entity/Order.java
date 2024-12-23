package com.kishan_shathi.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cropId;
    private String dealerId;
    private String farmerId;
    private Integer quantity;
    private String unit; 
    private String status;  // e.g., "Pending", "Shipped", "Delivered"
    private String orderAddress;
    
//    @ManyToOne
//    private Crop crop;
//
//    @ManyToOne
//    private Dealer dealer;
//
//    @ManyToOne
//    private Farmer farmer;

    // Getters and Setters
}
