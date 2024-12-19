package com.kishan_shathi.controller;

import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<FarmerDto> saveFarmer(@RequestBody FarmerDto farmerDto) {
        log.info("Saving farmer: {}", farmerDto);
        return ResponseEntity.ok(farmerService.saveFarmer(farmerDto));
    }

    // Update Farmer
    @PutMapping("/update/{id}")
    public ResponseEntity<FarmerDto> updateFarmer(@PathVariable String id, @RequestBody FarmerDto farmerDto) {
        log.info("Updating farmer with ID: {} Data: {}", id, farmerDto);
        return ResponseEntity.ok(farmerService.updateFarmer(id, farmerDto));
    }

    // Get Farmer by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<FarmerDto> getFarmerById(@PathVariable String id) {
        log.info("Fetching farmer with ID: {}", id);
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }

    // Get All Farmers
    @GetMapping("/get-all")
    public ResponseEntity<List<FarmerDto>> getAllFarmers() {
        log.info("Fetching all farmers");
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }
}
