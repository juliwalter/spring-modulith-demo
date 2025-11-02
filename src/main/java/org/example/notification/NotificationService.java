package org.example.notification;

import org.example.notification.model.Notification;

import java.util.List;

/**
 * Service interface for managing notifications
 *
 * @author julianwalter
 */
public interface NotificationService {
    /**
     * Retrieve all notifications
     *
     * @return the list of notifications
     */
    List<Notification> getNotifications();
}
