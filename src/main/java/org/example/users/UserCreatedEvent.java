package org.example.users;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event capturing the creation of a new user
 *
 * @author julianwalter
 */
@Getter
public class UserCreatedEvent extends ApplicationEvent {
    private final String username;

    public UserCreatedEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
}
