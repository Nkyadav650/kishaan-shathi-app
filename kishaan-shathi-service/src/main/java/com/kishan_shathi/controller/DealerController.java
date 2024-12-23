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
        try {
            DealerDto dto = dealerService.saveDealer(dealer);
            return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error saving dealer: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Update Dealer
    @PutMapping("/update/{id}")
    public ResponseEntity<Response<Object>> updateDealer(@PathVariable String id, @RequestBody DealerDto dealer) {
        log.info("Updating dealer with ID: {} Data: {}", id, dealer);
        try {
            DealerDto dto = dealerService.updateDealer(id, dealer);
            return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error updating dealer: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get Dealer by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Response<Object>> getDealerById(@PathVariable String id) {
        log.info("Fetching dealer with ID: {}", id);
        try {
            DealerDto dto = dealerService.getDealerById(id);
            return new CommonResponse<>().prepareSuccessResponseObject(dto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error fetching dealer: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Get All Dealers
    @GetMapping("/get-all")
    public ResponseEntity<Response<Object>> getAllDealers() {
        log.info("Fetching all dealers");
        try {
            List<DealerDto> dtoList = dealerService.getAllDealers();
            return new CommonResponse<>().prepareSuccessResponseObject(dtoList, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error fetching dealers: {}", e.getMessage());
            return new CommonResponse<>().prepareErrorResponseObject(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

