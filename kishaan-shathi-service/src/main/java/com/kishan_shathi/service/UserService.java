package com.kishan_shathi.service;

import com.kishan_shathi.dto.UserDto;
import com.kishan_shathi.model.LoginResponse;

public interface UserService {

	public String saveUsers(UserDto userEntityDto);

	public LoginResponse genarateJwtToken(String email);

	



}
