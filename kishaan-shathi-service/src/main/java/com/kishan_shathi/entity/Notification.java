package com.kishan_shathi.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notificationId;
    private String message;
    private String notificationType; // E.g., "Payment reminder", "Shelling request status"
    private String userId;
    private boolean isRead;
    private Date dateCreated;
}
