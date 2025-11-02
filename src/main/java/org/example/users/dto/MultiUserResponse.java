package org.example.users.dto;

import lombok.experimental.SuperBuilder;
import org.example.common.dto.GenericResponse;
import org.example.users.model.User;

import java.util.List;

/**
 * Response DTO containing a list of users
 *
 * @author julianwalter
 */
@SuperBuilder
public class MultiUserResponse extends GenericResponse {
    private List<User> users;
}
