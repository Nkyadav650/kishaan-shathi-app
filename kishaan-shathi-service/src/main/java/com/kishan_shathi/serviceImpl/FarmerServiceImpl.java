package com.kishan_shathi.serviceImpl;

import com.kishan_shathi.dto.FarmerDto;
import com.kishan_shathi.entity.Farmer;
import com.kishan_shathi.repository.FarmerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;
import com.kishan_shathi.service.FarmerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FarmerServiceImpl implements FarmerService {

    @Autowired
    private FarmerRepository farmerRepository;

    @Override
    public FarmerDto saveFarmer(FarmerDto farmerDto) {
        log.info("Saving farmer in database: {}", farmerDto);
        Farmer farmer = new Farmer();
        BeanUtils.copyProperties(farmerDto, farmer);
        Farmer savedFarmer = farmerRepository.save(farmer);
        FarmerDto savedFarmerDto = new FarmerDto();
        BeanUtils.copyProperties(savedFarmer, savedFarmerDto);
        return savedFarmerDto;
    }

    @Override
    public FarmerDto updateFarmer(String id, FarmerDto farmerDto) {
        log.info("Finding farmer with ID: {} for update", id);
        Optional<Farmer> existingFarmer = farmerRepository.findById(id);
        if (existingFarmer.isPresent()) {
            Farmer farmer = existingFarmer.get();
            BeanUtils.copyProperties(farmerDto, farmer);
            Farmer updatedFarmer = farmerRepository.save(farmer);
            FarmerDto updatedFarmerDto = new FarmerDto();
            BeanUtils.copyProperties(updatedFarmer, updatedFarmerDto);
            return updatedFarmerDto;
        }
        throw new RuntimeException("Farmer not found with id: " + id);
    }

    @Override
    public FarmerDto getFarmerById(String id) {
        log.info("Fetching farmer with ID: {}", id);
        Farmer farmer = farmerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Farmer not found with id: " + id));
        FarmerDto farmerDto = new FarmerDto();
        BeanUtils.copyProperties(farmer, farmerDto);
        return farmerDto;
    }

    @Override
    public List<FarmerDto> getAllFarmers() {
        log.info("Fetching all farmers from database");
        return farmerRepository.findAll().stream()
                .map(farmer -> {
                    FarmerDto farmerDto = new FarmerDto();
                    BeanUtils.copyProperties(farmer, farmerDto);
                    return farmerDto;
                })
                .collect(Collectors.toList());
    }
}
