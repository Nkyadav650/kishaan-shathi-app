package com.kishan_shathi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropDto {

	private String cropId; // Unique identifier for the crop (e.g., SKU or reference code)
	private String cropName; // Name of the crop (e.g., "Wheat", "Rice")
	private String cropType; // Type of crop (e.g., "Cereal", "Vegetable")
	private byte[] cropImage;
	private String cropSeason; // Season for the crop (e.g., "Summer", "Winter")
	private String soilType; // Preferred soil type (e.g., "Loamy", "Clay")
	private String irrigationType; // Type of irrigation used (e.g., "Drip", "Flood", "Sprinkler")
	private String qualityGrade; // Quality grade of the crop (e.g., "A", "B", "C")
	private String description;
}
