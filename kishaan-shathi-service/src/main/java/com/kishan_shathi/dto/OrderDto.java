package com.kishan_shathi.dto;

import lombok.Data;

@Data
public class OrderDto {
	private Long id;
    private Long cropId;
    private Long dealerId;
    private Long farmerId;
    private Integer quantity;
    private String status;  
    private String orderAddress;
}
