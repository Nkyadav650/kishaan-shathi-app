package com.kishan_shathi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Farmer {
	@Id
	private String farmerId;
	private String name;
	private String email;
	private String phoneNumber;
	private String address;

}
