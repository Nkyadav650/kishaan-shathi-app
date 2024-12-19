package com.kishan_shathi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kishan_shathi.commonresponse.CommonResponse;
import com.kishan_shathi.dto.CropDto;
import com.kishan_shathi.model.Response;
import com.kishan_shathi.service.CropService;

@RestController
@RequestMapping("/crop")
public class CropController {

	private CropService cropService;

	public CropController(CropService cropService) {
		this.cropService = cropService;
	}

	@PostMapping("/add")
	public ResponseEntity<Response<Object>> addCrop(@RequestBody CropDto cropDto) {
		CropDto dto = cropService.addCrop(cropDto);
		return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{cropId}")
	public ResponseEntity<Response<Object>> findCropById(@PathVariable String cropId){
		CropDto cropDetail = cropService.findCropDetails(cropId);
		return new CommonResponse<>().prepareSuccessResponseObject(cropDetail, HttpStatus.OK);
	}
}
