package org.example.users.controller;

import lombok.RequiredArgsConstructor;
import org.example.common.dto.GenericResponse;
import org.example.users.UserService;
import org.example.users.dto.CreateUserRequest;
import org.example.users.dto.MultiUserResponse;
import org.example.users.dto.SingleUserResponse;
import org.example.users.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing users.
 *
 * @author julianwalter
 */
@RestController
@RequiredArgsConstructor
class UserController {

    private final UserService service;

    /**
     * Retrieve all users
     *
     * @return response containing a list of all users
     */
    @GetMapping("user")
    ResponseEntity<GenericResponse> getUsers() {
        return createMultiUserResponse(service.getUsers());
    }

    /**
     * Retrieve a user by a given id
     *
     * @param id the user id
     * @return response containing the user to the given id
     */
    @GetMapping("user/{id}")
    ResponseEntity<GenericResponse> getUser(@PathVariable UUID id) {
        return service.getUser(id)
                .map(value -> createSingleUserResponse(value, "Successfully fetched user"))
                .orElse(createBadRequest("Unable to find user for id %s".formatted(id)));
    }

    /**
     * Creates a user with the provided user information
     *
     * @param request the user information
     * @return response containing the created user
     */
    @PostMapping("user")
    ResponseEntity<GenericResponse> createUser(@RequestBody CreateUserRequest request) {
        try {
            return createSingleUserResponse(
                    service.createUser(request.username()),
                    "Successfully created user"
            );
        }
        catch (Exception e) {
            return createBadRequest("Unable to create user");
        }
    }

    /**
     * Deletes a user by the given user id
     * @param id the user id
     * @return response containing information about the user deletion
     */
    @DeleteMapping("user/{id}")
    ResponseEntity<GenericResponse> deleteUser(@PathVariable UUID id) {
        return service.deleteUser(id)
                .map(user -> createGenericResponse("Successfully deleted user with id %s".formatted(id)))
                .orElse(createBadRequest("Unable to delete used with id %s".formatted(id)));
    }

    private ResponseEntity<GenericResponse> createSingleUserResponse(User user, String message) {
        return ResponseEntity.ok(
                SingleUserResponse.builder()
                        .user(user)
                        .additionalInformation(message)
                        .build());
    }

    private ResponseEntity<GenericResponse> createMultiUserResponse(List<User> users) {
        return ResponseEntity.ok(
                MultiUserResponse.builder()
                        .users(users)
                        .additionalInformation("Successfully fetched users")
                        .build());
    }

    private ResponseEntity<GenericResponse> createGenericResponse(String message) {
        return ResponseEntity.ok().body(
                GenericResponse.builder()
                        .additionalInformation(message)
                        .build()
        );
    }

    private ResponseEntity<GenericResponse> createBadRequest(String message) {
        return ResponseEntity.badRequest().body(
                GenericResponse.builder()
                        .additionalInformation(message)
                        .build()
        );
    }
}
