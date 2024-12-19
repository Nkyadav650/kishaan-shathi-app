package com.kishan_shathi.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
public class FarmerDto {
	    private Long farmerId;
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private String address;
	  
}
