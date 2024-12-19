package com.kishan_shathi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kishan_shathi.entity.Farmer;
import com.kishan_shathi.entity.Notification;
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}
