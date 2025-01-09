package com.kishan_shathi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String userId;
	private String name;
	private String password;
	private String role;
	private String email;
	private String phoneNumber;


}
