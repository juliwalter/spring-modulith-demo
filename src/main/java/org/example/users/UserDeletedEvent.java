package org.example.users;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event capturing the deletion of a user
 *
 * @author julianwalter
 */
@Getter
public class UserDeletedEvent extends ApplicationEvent {
    private final String username;

    public UserDeletedEvent(String username, Object source) {
        super(source);
        this.username = username;
    }
}
