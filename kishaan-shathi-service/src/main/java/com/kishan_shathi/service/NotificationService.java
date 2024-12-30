package com.kishan_shathi.service;

import com.kishan_shathi.entity.Notification;

import java.util.List;


public interface NotificationService {

    Notification createNotification(String message, String type, String userId);
    List<Notification> getNotificationsByUserId(String userId);
    void markAsRead(Long notificationId);
    void deleteNotification(Long notificationId);
}
