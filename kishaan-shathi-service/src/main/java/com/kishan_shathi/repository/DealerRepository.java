package com.kishan_shathi.repository;

import com.kishan_shathi.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DealerRepository extends JpaRepository<Dealer, String> {

}
