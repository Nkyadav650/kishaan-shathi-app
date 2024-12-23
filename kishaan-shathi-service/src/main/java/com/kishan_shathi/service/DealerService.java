package com.kishan_shathi.service;


import com.kishan_shathi.dto.DealerDto;

import java.util.List;

public interface DealerService {

     DealerDto saveDealer(DealerDto dealer);

    DealerDto updateDealer(String id, DealerDto dealer);

    DealerDto getDealerById(String id);

     List<DealerDto> getAllDealers();

}
