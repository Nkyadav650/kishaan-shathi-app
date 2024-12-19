package com.kishan_shathi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Crop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cropId;
	private String cropName;
	private String cropType;
	private byte[] cropImage;
	private String sellerId;
	private String sellerName;
	private Double pricePerUnit;
	private String unit;
	private Double availableQuantity;
	private Double minOrderQuantity;
	private String cropSeason;
	private String soilType;
	private String irrigationType;
	private String deliveryMethod;
	private String paymentTerms;
	private String description;
	private String status;
	private String sellerContact;
	private String harvestDate;
	private Boolean isCertifiedOrganic;
	private String qualityGrade;
}
