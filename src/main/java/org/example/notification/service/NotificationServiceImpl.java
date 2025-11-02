package org.example.notification.service;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.example.notification.NotificationService;
import org.example.notification.model.Notification;
import org.example.users.UserCreatedEvent;
import org.example.users.UserDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Implements the {@link NotificationService} interface
 *
 * @author julianwalter
 */
@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private List<Notification> notifications;

    @PostConstruct
    void init() {
        notifications = new ArrayList<>();
    }

    public List<Notification> getNotifications() {
        List<Notification> returnValues = notifications.stream().toList();
        notifications.clear();
        return returnValues;
    }

    /**
     * Event listener that reacts to a {@link UserCreatedEvent}.
     * <p>
     * Allows the notification module to respond to user creation events without tightly coupling
     * {@link NotificationService} to {@link org.example.users.UserService}. This supports modularity,
     * making it possible to separate the notification module without additional changes in other modules.
     *
     * @param event the event containing details about the newly created user
     */
    @Async
    @EventListener
    public void onUserCreateEvent(UserCreatedEvent event) {
        notifications.add(Notification.builder()
                .timestamp(Instant.now())
                .message("New user created %s".formatted(event.getUsername()))
                .build());
    }

    /**
     * Event listener that reacts to a {@link UserDeletedEvent}.
     * <p>
     * Allows the notification module to respond to user creation events without tightly coupling
     * {@link NotificationService} to {@link org.example.users.UserService}. This supports modularity,
     * making it possible to separate the notification module without additional changes in other modules.
     *
     * @param event the event containing details about a deleted user
     */
    @Async
    @EventListener
    public void onUserDeletedEvent(UserDeletedEvent event) {
        notifications.add(Notification.builder()
                .timestamp(Instant.now())
                .message("Deleted user %s".formatted(event.getUsername()))
                .build());
    }
}
