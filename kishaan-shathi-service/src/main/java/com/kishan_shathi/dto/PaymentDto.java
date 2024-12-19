package com.kishan_shathi.dto;

import com.kishan_shathi.requestenum.PaymentStatus;

import lombok.Data;

@Data
public class PaymentDto {
   
	private Long paymentId;
    private Double amount;    
    private PaymentStatus status;
    private String paymentMethod;
    private Long shellingRequest;

}

