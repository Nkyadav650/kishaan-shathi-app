package com.kishan_shathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishan_shathi.entity.Dealer;
import com.kishan_shathi.entity.Farmer;
@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

}
