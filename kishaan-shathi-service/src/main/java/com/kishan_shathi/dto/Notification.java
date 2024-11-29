package com.kishan_shathi.dto;

import java.util.Date;

import com.kishan_shathi.entity.UserEntity;

import lombok.Data;

@Data
public class Notification {

	private Long notificationId;
	private String message;
	private String notificationType; 
	private UserEntity user;
	private boolean isRead;
	private Date dateCreated;
}
