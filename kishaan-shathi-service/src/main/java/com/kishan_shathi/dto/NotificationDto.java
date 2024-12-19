package com.kishan_shathi.dto;

import java.util.Date;

import lombok.Data;

@Data
public class NotificationDto {

	private Long notificationId;
	private String message;
	private String notificationType; 
	private String userId;
	private boolean isRead;
	private Date dateCreated;
}
