package org.example.users.dto;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.common.dto.GenericResponse;
import org.example.users.model.User;

/**
 * Response DTO containing a single user
 *
 * @author julianwalter
 */
@SuperBuilder
@NoArgsConstructor
public class SingleUserResponse extends GenericResponse {
    private User user;
}
