package com.kishan_shathi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishan_shathi.entity.Farmer;
import com.kishan_shathi.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	Optional<UserEntity> findByEmail(String username);

}
