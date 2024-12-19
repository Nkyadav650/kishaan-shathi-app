package com.kishan_shathi.dto;

import lombok.Data;

@Data
public class OrderDto {
	private Long id;
    private String cropId;
    private String dealerId;
    private String farmerId;
    private Integer quantity;
    private String unit; 
    private String status;  
    private String orderAddress;
}
