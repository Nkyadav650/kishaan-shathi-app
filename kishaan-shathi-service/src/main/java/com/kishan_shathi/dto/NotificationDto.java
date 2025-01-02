package com.kishan_shathi.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {

	private Long notificationId;
	private String message;
	private String notificationType; 
	private String userId;
	private boolean isRead;
	private Date dateCreated;


}
