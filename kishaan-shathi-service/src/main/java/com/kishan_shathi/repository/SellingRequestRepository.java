package com.kishan_shathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishan_shathi.entity.SellingRequest;
@Repository
public interface SellingRequestRepository extends JpaRepository<SellingRequest, Long> {

}
