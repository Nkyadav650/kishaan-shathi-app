package com.kishan_shathi.dto;

import java.util.List;

import lombok.Data;

@Data

public class Dealer {
    
    private Long dealerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private List<ShellingRequest> shellingRequests;

}
