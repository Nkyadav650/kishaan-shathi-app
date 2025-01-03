package com.kishan_shathi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Crop {

	@Id
	private String cropId;
	private String cropName;
	private String cropType;
	private byte[] cropImage;
	private String qualityGrade;
	private String cropSeason;
	private String soilType;
	private String irrigationType;
	private String description;
}
