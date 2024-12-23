package com.kishan_shathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishan_shathi.entity.Crop;
@Repository
public interface CropRepository extends JpaRepository<Crop, String> {

}
