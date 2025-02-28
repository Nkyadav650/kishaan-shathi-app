package com.kishan_shathi.serviceImpl;

import com.kishan_shathi.entity.Notification;
import com.kishan_shathi.repository.NotificationRepository;
import com.kishan_shathi.service.NotificationService;
import com.kishan_shathi.service.WebSocketNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    private final WebSocketNotificationService webSocketNotificationService;


    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository, WebSocketNotificationService webSocketNotificationService) {
        this.notificationRepository = notificationRepository;
        this.webSocketNotificationService = webSocketNotificationService;
    }

    @Override
    public Notification createNotification(String message, String type, String userId) {
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setNotificationType(type);
        notification.setUserId(userId);
        notification.setRead(false);
        notification.setDateCreated(new Date());
//        return notificationRepository.save(notification);
        Notification savedNotification = notificationRepository.save(notification);

        // Broadcast notification via WebSocket
        webSocketNotificationService.sendNotification("/topic/notifications", savedNotification);

        return savedNotification;
    }

    @Override
    public List<Notification> getNotificationsByUserId(String userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public void markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setRead(true);
        notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(Long notificationId) {
        notificationRepository.deleteById(notificationId);
    }
}
