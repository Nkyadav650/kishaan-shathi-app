package com.kishan_shathi.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cropId;
    private Long dealerId;
    private Long farmerId;
    private Integer quantity;
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
