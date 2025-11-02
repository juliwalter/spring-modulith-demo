package org.example.users.dto;

import java.io.Serializable;

/**
 * DTO for a user creation request
 *
 * @param username the username for the user
 */
public record CreateUserRequest(String username) implements Serializable {
}
