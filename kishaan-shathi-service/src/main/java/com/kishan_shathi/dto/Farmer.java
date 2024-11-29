package com.kishan_shathi.dto;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class Farmer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long farmerId;
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private String address;
	    private List<ShellingRequest> shellingRequests;
}
