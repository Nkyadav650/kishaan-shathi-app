package com.kishan_shathi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kishan_shathi.commonresponse.CommonResponse;
import com.kishan_shathi.dto.CropDto;
import com.kishan_shathi.model.Response;
import com.kishan_shathi.service.CropService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

@RestController
@RequestMapping("/crop")
@Slf4j
public class CropController {

	private CropService cropService;

	public CropController(CropService cropService) {
		this.cropService = cropService;
	}

//	@PostMapping("/add")
//	public ResponseEntity<Response<Object>> addCrop(@RequestBody CropDto cropDto) {
//		log.info("Crop Controller addCrop method entered.");
//		CropDto dto = cropService.addCrop(cropDto);
//		return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
//	}


	@PostMapping("/add")
	public ResponseEntity<Response<Object>> addCrop(
			@RequestParam("cropName") String cropName,
			@RequestParam("cropType") String cropType,
			@RequestParam("cropSeason") String cropSeason,
			@RequestParam("soilType") String soilType,
			@RequestParam("irrigationType") String irrigationType,
			@RequestParam("qualityGrade") String qualityGrade,
			@RequestParam("description") String description,
			@RequestParam("cropImage") MultipartFile cropImage) {

		log.info("Crop Controller addCrop method entered.");

		try {
			// Validate image size if needed (optional)
			if (cropImage.getSize() > (16 * 1024 * 1024)) { // 16 MB limit
				throw new IllegalArgumentException("File size exceeds the limit of 16 MB");
			}

			// Create DTO and set values
			CropDto cropDto = new CropDto();
			cropDto.setCropName(cropName);
			cropDto.setCropType(cropType);
			cropDto.setCropSeason(cropSeason);
			cropDto.setSoilType(soilType);
			cropDto.setIrrigationType(irrigationType);
			cropDto.setQualityGrade(qualityGrade);
			cropDto.setDescription(description);
			cropDto.setCropImage(cropImage.getBytes()); // Convert image to byte[]

			// Call service to save crop
			CropDto dto = cropService.addCrop(cropDto);
			return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error occurred while adding crop: {}", e.getMessage());
			return new CommonResponse<>().prepareErrorResponseObject("Failed to add crop", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/find/{cropId}")
	public ResponseEntity<Response<Object>> findCropById(@PathVariable String cropId){
		CropDto cropDetail = cropService.findCropDetails(cropId);
		return new CommonResponse<>().prepareSuccessResponseObject(cropDetail, HttpStatus.OK);
	}
}
