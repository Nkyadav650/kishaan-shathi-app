package com.kishan_shathi.dto;

import lombok.Data;

@Data
public class UserDto {

	private String userId;
	private String name;
	private String password;
	private String role;
	private String email;
	private String phoneNumber;
}
