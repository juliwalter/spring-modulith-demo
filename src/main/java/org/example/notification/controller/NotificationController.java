package org.example.notification.controller;

import lombok.RequiredArgsConstructor;
import org.example.notification.NotificationService;
import org.example.notification.model.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing notifications.
 *
 * @author julianwalter
 */
@RestController
@RequiredArgsConstructor
class NotificationController {

    private final NotificationService service;

    /**
     * Retrieve all notifications
     *
     * @return a list of all notifications
     */
    @GetMapping("notification")
    private ResponseEntity<List<Notification>> getNotifications() {
        return ResponseEntity.ok(service.getNotifications());
    }
}
