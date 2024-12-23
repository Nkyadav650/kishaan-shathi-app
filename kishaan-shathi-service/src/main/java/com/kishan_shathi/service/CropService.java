package com.kishan_shathi.service;

import java.util.List;

import com.kishan_shathi.dto.CropDto;

public interface CropService {

	public CropDto addCrop(CropDto cropDto);
	
	//get crop
	public CropDto findCropDetails(String cropId);
	
	//update
	public CropDto udateCropDetails(String cropId,CropDto CropDto);
	
	// FindAll
	public List<CropDto> findAllCrops();
}
