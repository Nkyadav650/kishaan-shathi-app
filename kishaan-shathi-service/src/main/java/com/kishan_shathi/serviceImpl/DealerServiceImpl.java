package com.kishan_shathi.serviceImpl;

import com.kishan_shathi.dto.DealerDto;
import com.kishan_shathi.entity.Dealer;
import com.kishan_shathi.repository.DealerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import com.kishan_shathi.service.DealerService;

import java.util.List;


@Service
@Slf4j
public class DealerServiceImpl implements DealerService {

    @Autowired
    private DealerRepository dealerRepository;

    public DealerServiceImpl(DealerRepository dealerRepository) {
        this.dealerRepository = dealerRepository;
    }


    @Override
    public DealerDto saveDealer(DealerDto dealerDto) {
        Dealer dealer = new Dealer();
        BeanUtils.copyProperties(dealerDto, dealer);
        Dealer savedDealer = dealerRepository.save(dealer);
        DealerDto savedDealerDto = new DealerDto();
        BeanUtils.copyProperties(savedDealer, savedDealerDto);
        return savedDealerDto;
    }

    @Override
    public DealerDto updateDealer(String id, DealerDto dealerDto) {
        Dealer existingDealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + id));

        existingDealer.setName(dealerDto.getName());
        existingDealer.setPhoneNumber(dealerDto.getPhoneNumber());
        existingDealer.setAddress(dealerDto.getAddress());
        existingDealer.setEmail(dealerDto.getEmail());

        Dealer updatedDealer = dealerRepository.save(existingDealer);

        DealerDto updatedDealerDto = new DealerDto();
        BeanUtils.copyProperties(updatedDealer, updatedDealerDto);
        return updatedDealerDto;
    }

    @Override
    public DealerDto getDealerById(String id) {
        Dealer dealer = dealerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + id));
        DealerDto dealerDto = new DealerDto();
        BeanUtils.copyProperties(dealer, dealerDto);
        return dealerDto;
    }

    @Override
    public List<DealerDto> getAllDealers() {
        return dealerRepository.findAll().stream()
                .map(dealer -> {
                    DealerDto dealerDto = new DealerDto();
                    BeanUtils.copyProperties(dealer, dealerDto);
                    return dealerDto;
                })
                .toList();
    }

}
