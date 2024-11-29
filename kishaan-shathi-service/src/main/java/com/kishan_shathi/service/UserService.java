package com.kishan_shathi.service;

import com.kishan_shathi.dto.UserEntityDto;
import com.kishan_shathi.model.LoginResponse;

public interface UserService {

	public String saveUsers(UserEntityDto userEntityDto);

	public LoginResponse genarateJwtToken(String email);

	



}
