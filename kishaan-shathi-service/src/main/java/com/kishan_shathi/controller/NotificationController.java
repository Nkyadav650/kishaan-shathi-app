package com.kishan_shathi.controller;

import com.kishan_shathi.dto.NotificationDto;
import com.kishan_shathi.entity.Notification;
import com.kishan_shathi.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {


    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification createNotification(@RequestBody Notification notificationRequest) {
        return notificationService.createNotification(
                notificationRequest.getMessage(),
                notificationRequest.getNotificationType(),
                notificationRequest.getUserId()
        );
    }


    @GetMapping("/{userId}")
    public List<NotificationDto> getNotifications(@PathVariable String userId) {
        return notificationService.getNotificationsByUserId(userId).stream()
                .map(notification -> new NotificationDto(
                        notification.getNotificationId(),
                        notification.getMessage(),
                        notification.getNotificationType(),
                        notification.getUserId(),
                        notification.isRead(),
                        notification.getDateCreated()
                ))
                .collect(Collectors.toList());
    }
    @PutMapping("/{notificationId}/read")
    public void markAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
    }

    @DeleteMapping("/{notificationId}")
    public void deleteNotification(@PathVariable Long notificationId) {
        notificationService.deleteNotification(notificationId);
    }
}
