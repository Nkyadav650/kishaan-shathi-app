package com.kishan_shathi.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.google.api.client.json.Json;
import com.kishan_shathi.dto.UserDto;
import com.kishan_shathi.entity.UserEntity;
import com.kishan_shathi.jwt.JwtService;
import com.kishan_shathi.model.LoginResponse;
import com.kishan_shathi.repository.UserRepository;
import com.kishan_shathi.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;
	private final JwtService jwtService;
	private final PasswordEncoder encoder;
	private final MyUserDetailasService myUserDetailasService;
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepo, JwtService jwtService, PasswordEncoder encoder, MyUserDetailasService myUserDetailasService, UserRepository userRepository) {
		this.userRepo=userRepo;
		this.jwtService=jwtService;
		this.myUserDetailasService=myUserDetailasService;
		this.encoder=encoder;
        this.userRepository = userRepository;
    }

	@Override
	public String saveUsers(UserDto userEntityDto) {
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(userEntityDto, userEntity);
		log.info("user Entity data to save : {}",userEntity);
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		userRepo.save(userEntity);
		 return "User saved successfully";
	}

	@Override
	public LoginResponse genarateJwtToken(String email) {
		log.info("login service entered along with email :{}",email);
		String jwtToken = jwtService.genarateJwtToken(myUserDetailasService.loadUserByUsername(email));
		log.info("genarated token is : {}",jwtToken);
		String jwtRefreshToken = jwtService.genarateRefreshToken(myUserDetailasService.loadUserByUsername(email));
		
		return LoginResponse.builder()
				.jwtToken(jwtToken)
				.refreshToken(jwtRefreshToken)
				.userdetails(userRepo.findByEmail(email).get()).build();
	}


	@Override
	public List<UserDto> getAllUsers() {
		// Fetch all users and map them to UserDto objects
		return userRepository.findAll().stream()
				.map(user -> new UserDto(
						user.getUserId(),
						user.getName(),
						null, // Exclude sensitive fields like password
						user.getRole(),
						user.getEmail(),
						user.getPhoneNumber()
				))
				.collect(Collectors.toList());
	}

}
