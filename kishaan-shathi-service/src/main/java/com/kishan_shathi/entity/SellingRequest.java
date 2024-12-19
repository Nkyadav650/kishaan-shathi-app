package com.kishan_shathi.entity;

import java.util.Date;

import com.kishan_shathi.requestenum.RequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class SellingRequest {
	   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    private String cropType;
    private Double quantity;
    private Double cost; 
    private RequestStatus status; // Enum for status
    private String sellerId;
	private String sellerName;
	private Double pricePerUnit;
	private String unit;
	private Double availableQuantity;
	private Double minOrderQuantity;
	private String deliveryMethod;
	private String paymentTerms;
	private String description;
	private String sellerContact;
	private String harvestDate;
	private Boolean isCertifiedOrganic;
    private Date requestDate;
    private Date expectedCompletionDate;
}
