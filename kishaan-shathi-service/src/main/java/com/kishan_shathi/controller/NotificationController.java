package com.kishan_shathi.controller;

import com.kishan_shathi.dto.NotificationDto;
import com.kishan_shathi.dto.UserDto;
import com.kishan_shathi.entity.Notification;
import com.kishan_shathi.service.NotificationService;
import com.kishan_shathi.service.UserService;
import com.kishan_shathi.service.WebSocketNotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {


    private final NotificationService notificationService;
    private final WebSocketNotificationService webSocketNotificationService;
    private final UserService userService; // To fetch user details


    @Autowired
    public NotificationController(NotificationService notificationService, WebSocketNotificationService webSocketNotificationService, UserService userService) {
        this.notificationService = notificationService;
        this.webSocketNotificationService = webSocketNotificationService;
        this.userService = userService;
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


//    @PostMapping("/{userId}/send")
//    public void sendNotificationToUser(
//            @PathVariable String userId,
//            @RequestBody NotificationDto notificationDto) {
//        // Create and save the notification
//        Notification notification = notificationService.createNotification(
//                notificationDto.getMessage(),
//                notificationDto.getNotificationType(),
//                userId
//        );
//
//        // Broadcast notification to the specific user via WebSocket
//        String destination = "/topic/notifications/" + userId;
//        webSocketNotificationService.sendNotification(destination, notification);
//
//        log.info("Notification sent to user with ID: {}", userId);
//    }





    @PostMapping("/send-to-all")
    public void sendNotificationToAll(@RequestBody NotificationDto notificationDto) {
        // Fetch all UserDto objects from the database
        List<UserDto> allUsers = userService.getAllUsers();

        // Iterate over each user and send the notification
        for (UserDto user : allUsers) {
            String userId = user.getUserId();

            // Create and save the notification for each user
            Notification notification = notificationService.createNotification(
                    notificationDto.getMessage(),
                    notificationDto.getNotificationType(),
                    userId
            );

            // Broadcast notification to the user-specific WebSocket topic
            String destination = "/topic/notifications/" + userId;
            webSocketNotificationService.sendNotification(destination, notification);
        }

        log.info("Notification sent to all users");
    }



    @PostMapping("/{userId}/send")
    public NotificationDto sendNotificationToUser(
            @PathVariable String userId,
            @RequestBody Map<String, String> request) {
        String message = request.get("message");
        String notificationType = request.get("notificationType");

        // Create and save the notification
        Notification notification = notificationService.createNotification(message, notificationType, userId);

        // Broadcast notification to the specific user via WebSocket
        String destination = "/topic/notifications/" + userId;
        webSocketNotificationService.sendNotification(destination, notification);

        log.info("Notification sent to user with ID: {}", userId);

        // Return the response in NotificationDto format
        return new NotificationDto(
                notification.getNotificationId(),
                notification.getMessage(),
                notification.getNotificationType(),
                notification.getUserId(),
                notification.isRead(),
                notification.getDateCreated()
        );
    }

}
