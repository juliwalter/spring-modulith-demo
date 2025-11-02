package org.example.users;

import org.example.users.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author julianwalter
 */
public interface UserService {

    /**
     * Creates a user with a given username
     *
     * @param username the username of the created user
     * @return the created user
     */
    User createUser(String username);

    /**
     * Deletes a user defined by its UUID
     *
     * @param id the UUID of the user
     * @return optional containing the user if the user could be found, otherwise empty optional
     */
    Optional<User> deleteUser(UUID id);

    /**
     * Gets all the users
     *
     * @return the list of users
     */
    List<User> getUsers();

    /**
     * Gets a user by its UUID
     *
     * @param id the UUID of the user
     * @return optional containing the user if the user could be found, otherwise empty optional
     */
    Optional<User> getUser(UUID id);
}

