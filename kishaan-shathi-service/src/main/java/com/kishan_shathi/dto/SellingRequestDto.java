package com.kishan_shathi.dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class SellingRequestDto {
	   
    private Long requestId;
    private String cropId;
    private String cropType;
    private Double quantity;
    private Double cost;
    private String status; // Status of the crop (e.g., "Available", "Sold Out", "In Transit")
	private String sellerId; // Seller's unique ID (this can be a foreign key from a seller entity)
	private String sellerName; // Name of the seller (e.g., "Kishan Farms")
	private Double pricePerUnit; // Price per unit (e.g., per kilogram, per bag)
	private String unit; // Unit of sale (e.g., "kg", "bag", "ton")
	private Double availableQuantity; // Quantity available for sale (e.g., in kg or tons)
	private Double minOrderQuantity; // Minimum order quantity (e.g., in kg or tons)
	private String deliveryMethod; // Delivery method (e.g., "Home Delivery", "Pick-up")
	private String paymentTerms; // Payment terms (e.g., "Prepaid", "COD", "Installments")
	private String description; // Description of the crop (e.g., "High-quality wheat for flour production")
	private String sellerContact; // Seller's contact information (phone or email)
	private String harvestDate; // Expected or actual harvest date (e.g., "2024-10-15")
	
	// Optionally, if the crop is certified (e.g., organic certification)
	private Boolean isCertifiedOrganic; // Whether the crop is certified organic (true/false)
    private Date requestDate;
    private Date expectedCompletionDate;
}
