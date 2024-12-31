package com.kishan_shathi.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.kishan_shathi.commonresponse.CommonResponse;
import com.kishan_shathi.config.OauthSuccessHandler;
import com.kishan_shathi.dto.UserDto;
import com.kishan_shathi.exception.InValidUserExcepption;
import com.kishan_shathi.model.LoginRequest;
import com.kishan_shathi.model.Response;
import com.kishan_shathi.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	private final AuthenticationManager manager;
	private final OauthSuccessHandler oauthSuccessHandler;

	public UserController(UserService userService,AuthenticationManager manager,OauthSuccessHandler oauthSuccessHandler) {
		this.userService=userService;
		this.manager=manager;
		this.oauthSuccessHandler=oauthSuccessHandler;
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<Response<Object>> saveUsers(@RequestBody UserDto userEntityDto){
		String result = userService.saveUsers(userEntityDto);
		return new CommonResponse<>().prepareSuccessResponseObject(result, HttpStatus.CREATED);
	}
	
	@PostMapping("/manual/login")
	public ResponseEntity<Response<Object>> manualLogin(@RequestBody LoginRequest login) throws InValidUserExcepption{
		log.info("login controller entered");
		if (manager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword())).isAuthenticated()) {
			log.info("login controller if block  entered");
			return new CommonResponse<>()
					.prepareSuccessResponseObject(
							userService.genarateJwtToken(login.getUsername()), HttpStatus.OK);
		} else {
			log.info("else in logincontroller ");
			throw new InValidUserExcepption("Invalid Credintials!!!");
		}
		
	}
	
	@PostMapping("/google/login")
	public ResponseEntity<?> googleLogin(@RequestBody Map<String, String> payload) {

        String code = payload.get("code");
        log.info("Entering Google Login method code :{}", code);
        String accessToken = oauthSuccessHandler.fetchAccessTokenFromGoogle(code);
        log.info("Entering Google Login method got access token : {}", accessToken);
        String email = oauthSuccessHandler.fetchUserInfoFromGoogle(accessToken);
        log.info("Entering Google Login method got email: {}", email);
        	return new CommonResponse<>()
					.prepareSuccessResponseObject(
							userService.genarateJwtToken(email), HttpStatus.OK);
	}
	
	
	
}
