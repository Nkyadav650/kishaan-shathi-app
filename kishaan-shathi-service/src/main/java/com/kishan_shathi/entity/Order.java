package com.kishan_shathi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
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
