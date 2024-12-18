package com.kishan_shathi.dto;

import lombok.Data;

@Data
public class UserDto {

	private Long userId;
	private String name;
	private String password;
	private String role;
	private String email;
	private String phoneNumber;
}
