package com.kishan_shathi.controller;

import com.kishan_shathi.entity.Notification;
import com.kishan_shathi.service.WebSocketNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NotificationWebSocketController {

    @Autowired
    WebSocketNotificationService webSocketNotificationService;

    @Autowired
    public NotificationWebSocketController(WebSocketNotificationService webSocketNotificationService) {
        this.webSocketNotificationService = webSocketNotificationService;
    }

    @MessageMapping("/sendNotification")
    @SendTo("/topic/notifications")
    public Notification broadcastNotification(Notification notification) {
        return notification;
    }
}
