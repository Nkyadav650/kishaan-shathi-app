package com.kishan_shathi.entity;

import com.kishan_shathi.requestenum.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Payment {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status; // Enum for payment status
    private String paymentMethod;
    private Long shellingRequest;

}

