package org.example.notification.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * Notification bean
 *
 * @author julianwalter
 */
@Data
@Builder
public class Notification implements Serializable {
    private Instant timestamp;
    private String message;
}
