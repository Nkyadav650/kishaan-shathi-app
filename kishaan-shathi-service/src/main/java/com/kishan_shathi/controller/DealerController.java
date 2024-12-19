package com.kishan_shathi.controller;

import com.kishan_shathi.dto.DealerDto;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import com.kishan_shathi.service.DealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
@Slf4j
public class DealerController {

    @Autowired
    private DealerService dealerService;

    // Save Dealer
    @PostMapping("/save")
    public ResponseEntity<DealerDto> saveDealer(@RequestBody DealerDto dealer) {
        log.info("Saving dealer: {}", dealer);
        return ResponseEntity.ok(dealerService.saveDealer(dealer));
    }

    // Update Dealer
    @PutMapping("/update/{id}")
    public ResponseEntity<DealerDto> updateDealer(@PathVariable String id, @RequestBody DealerDto dealer) {
        log.info("Updating dealer with ID: {} Data: {}", id, dealer);
        return ResponseEntity.ok(dealerService.updateDealer(id, dealer));
    }

    // Get Dealer by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<DealerDto> getDealerById(@PathVariable String id) {
        log.info("Fetching dealer with ID: {}", id);
        return ResponseEntity.ok(dealerService.getDealerById(id));
    }

    // Get All Dealers
    @GetMapping("/get-all")
    public ResponseEntity<List<DealerDto>> getAllDealers() {
        log.info("Fetching all dealers");
        return ResponseEntity.ok(dealerService.getAllDealers());
    }
}

