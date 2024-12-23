package com.kishan_shathi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.kishan_shathi.commonresponse.CommonResponse;
import com.kishan_shathi.model.Response;
import org.springframework.http.HttpStatus;
import lombok.extern.slf4j.Slf4j;
import com.kishan_shathi.dto.FarmerDto;
import com.kishan_shathi.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@Slf4j
public class FarmerController {

    @Autowired
    private FarmerService farmerService;

    // Save Farmer
    @PostMapping("/save")
    public ResponseEntity<Response<Object>> saveFarmer(@RequestBody FarmerDto farmerDto) {
        log.info("Saving farmer: {}", farmerDto);
        try {
            FarmerDto dto = farmerService.saveFarmer(farmerDto);
            return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error saving farmer: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update Farmer
    @PutMapping("/update/{id}")
    public ResponseEntity<Response<Object>> updateFarmer(@PathVariable String id, @RequestBody FarmerDto farmerDto) {
        log.info("Updating farmer with ID: {} Data: {}", id, farmerDto);
        try {
            FarmerDto dto = farmerService.updateFarmer(id, farmerDto);
            return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error updating farmer: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get Farmer by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Response<Object>> getFarmerById(@PathVariable String id) {
        log.info("Fetching farmer with ID: {}", id);
        try {
            FarmerDto dto = farmerService.getFarmerById(id);
            return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error fetching farmer: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get All Farmers
    @GetMapping("/get-all")
    public ResponseEntity<Response<Object>> getAllFarmers() {
        log.info("Fetching all farmers");
        try {
            List<FarmerDto> dtoList = farmerService.getAllFarmers();
            return new CommonResponse<>().prepareSuccessResponseObject(dtoList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error fetching farmers: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
