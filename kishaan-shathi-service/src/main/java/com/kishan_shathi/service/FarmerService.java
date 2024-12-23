package com.kishan_shathi.service;

import com.kishan_shathi.dto.FarmerDto;

import java.util.List;

public interface FarmerService {

    FarmerDto saveFarmer(FarmerDto farmerDto);
    FarmerDto updateFarmer(String id, FarmerDto farmerDto);
    FarmerDto getFarmerById(String id);
    List<FarmerDto> getAllFarmers();
}
