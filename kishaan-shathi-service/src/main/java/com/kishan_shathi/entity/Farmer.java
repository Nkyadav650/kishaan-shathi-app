package com.kishan_shathi.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Farmer {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long farmerId;

	    private String name;
	    private String email;
	    private String phoneNumber;
	    private String address;

	    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<ShellingRequest> shellingRequests;
}
