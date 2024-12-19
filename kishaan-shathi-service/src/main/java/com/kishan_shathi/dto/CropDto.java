package com.kishan_shathi.dto;

import lombok.Data;

@Data
public class CropDto {

	private Long id;
	private String cropId; // Unique identifier for the crop (e.g., SKU or reference code)
	private String cropName; // Name of the crop (e.g., "Wheat", "Rice")
	private String cropType; // Type of crop (e.g., "Cereal", "Vegetable")
	private byte[] cropImage;
	private String sellerId; // Seller's unique ID (this can be a foreign key from a seller entity)
	private String sellerName; // Name of the seller (e.g., "Kishan Farms")

	private Double pricePerUnit; // Price per unit (e.g., per kilogram, per bag)
	private String unit; // Unit of sale (e.g., "kg", "bag", "ton")

	private Double availableQuantity; // Quantity available for sale (e.g., in kg or tons)
	private Double minOrderQuantity; // Minimum order quantity (e.g., in kg or tons)

	private String cropSeason; // Season for the crop (e.g., "Summer", "Winter")
	private String soilType; // Preferred soil type (e.g., "Loamy", "Clay")
	private String irrigationType; // Type of irrigation used (e.g., "Drip", "Flood", "Sprinkler")

	private String deliveryMethod; // Delivery method (e.g., "Home Delivery", "Pick-up")
	private String paymentTerms; // Payment terms (e.g., "Prepaid", "COD", "Installments")

	private String description; // Description of the crop (e.g., "High-quality wheat for flour production")
	private String status; // Status of the crop (e.g., "Available", "Sold Out", "In Transit")

	// Additional information related to the sale
	private String sellerContact; // Seller's contact information (phone or email)
	private String harvestDate; // Expected or actual harvest date (e.g., "2024-10-15")

	// Optionally, if the crop is certified (e.g., organic certification)
	private Boolean isCertifiedOrganic; // Whether the crop is certified organic (true/false)

	// Additional optional fields
	private String qualityGrade; // Quality grade of the crop (e.g., "A", "B", "C")

}
