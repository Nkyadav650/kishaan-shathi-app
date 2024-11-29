package com.kishan_shathi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kishan_shathi.entity.UserEntity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {
	@JsonProperty("jwtToken")
	private String jwtToken;
	@JsonProperty("refreshToken")
	private String refreshToken;
	@JsonProperty("userDetails")
	private UserEntity userdetails;
}
