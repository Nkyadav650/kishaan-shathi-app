package com.kishan_shathi.serviceImpl;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kishan_shathi.entity.UserEntity;
import com.kishan_shathi.repository.UserRepository;

@Service
public class MyUserDetailasService implements UserDetailsService{

	private final UserRepository userRepo;
	public MyUserDetailasService(UserRepository userRepo) {
		this.userRepo=userRepo;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user= userRepo.findByEmail(username);
		UserEntity users =user.get();
		if(user.isPresent()) {
			return  User.builder()
					.username(users.getEmail())
					.password(users.getPassword())
					.roles(getRoles(users))
					.build();
		}
		else {
			throw new UsernameNotFoundException(username);
		}
		
	}
	private String getRoles(UserEntity users) {
		// TODO Auto-generated method stub
		if(users.getRole()==null) {
			return "USER";
		}
		return users.getRole();
	}

}
