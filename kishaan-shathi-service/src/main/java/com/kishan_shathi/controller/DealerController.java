package com.kishan_shathi.controller;

import com.kishan_shathi.commonresponse.CommonResponse;
import com.kishan_shathi.dto.DealerDto;
import com.kishan_shathi.model.Response;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Response<Object>> saveDealer(@RequestBody DealerDto dealer) {
        log.info("Saving dealer: {}", dealer);
        DealerDto dto=dealerService.saveDealer(dealer);
        return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
    }

    // Update Dealer
    @PutMapping("/update/{id}")
    public ResponseEntity<Response<Object>> updateDealer(@PathVariable String id, @RequestBody DealerDto dealer) {
        log.info("Updating dealer with ID: {} Data: {}", id, dealer);
        DealerDto dto=dealerService.updateDealer(id, dealer);
        return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);

    }

    // Get Dealer by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Response<Object>> getDealerById(@PathVariable String id) {
        log.info("Fetching dealer with ID: {}", id);
        DealerDto dto=dealerService.getDealerById(id);
        return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
    }

    // Get All Dealers
    @GetMapping("/get-all")
    public ResponseEntity<List<DealerDto>> getAllDealers() {
        log.info("Fetching all dealers");
        return ResponseEntity.ok(dealerService.getAllDealers());
    }
}

