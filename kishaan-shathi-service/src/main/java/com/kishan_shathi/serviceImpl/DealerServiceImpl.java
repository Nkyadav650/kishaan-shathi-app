package com.kishan_shathi.serviceImpl;

import com.kishan_shathi.dto.DealerDto;
import com.kishan_shathi.entity.Dealer;
import com.kishan_shathi.repository.DealerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.beanutils.BeanUtils;


import com.kishan_shathi.service.DealerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository dealerRepository;


    @Override
    public DealerDto saveDealer(DealerDto dealerDto) {
        Dealer dealer = new Dealer();
        try {
            BeanUtils.copyProperties(dealer, dealerDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dealer savedDealer = dealerRepository.save(dealer);
        DealerDto savedDealerDto = new DealerDto();
        try {
            BeanUtils.copyProperties(savedDealerDto, savedDealer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return savedDealerDto;
    }

    @Override
    public DealerDto updateDealer(String id, DealerDto dealerDto) {
        Optional<Dealer> existingDealer = dealerRepository.findById(String.valueOf(id));
        if (existingDealer.isPresent()) {
            Dealer dealer = existingDealer.get();
            try {
                BeanUtils.copyProperties(dealer, dealerDto);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Dealer updatedDealer = dealerRepository.save(dealer);
            DealerDto updatedDealerDto = new DealerDto();
            try {
                BeanUtils.copyProperties(updatedDealerDto, updatedDealer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return updatedDealerDto;
        }
        throw new RuntimeException("Dealer not found with id: " + id);
    }

    @Override
    public DealerDto getDealerById(String id) {
        Dealer dealer = dealerRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + id));
        DealerDto dealerDto = new DealerDto();
        try {
            BeanUtils.copyProperties(dealerDto, dealer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dealerDto;
    }

    @Override
    public List<DealerDto> getAllDealers() {
        log.info("Fetching all dealers from database");
        return dealerRepository.findAll().stream()
                .map(dealer -> {
                    DealerDto dealerDto = new DealerDto();
                    try {
                        BeanUtils.copyProperties(dealerDto, dealer);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return dealerDto;
                })
                .collect(Collectors.toList());
    }
}
