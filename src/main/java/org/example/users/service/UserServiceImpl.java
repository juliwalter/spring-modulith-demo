package org.example.users.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.users.UserCreatedEvent;
import org.example.users.UserDeletedEvent;
import org.example.users.UserService;
import org.example.users.model.User;
import org.example.users.repository.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementation of the {@link UserService} interface
 *
 * @author julianwalter
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final ApplicationEventPublisher publisher;

    public User createUser(String username) {
        User user = repo.save(User.builder()
                .username(username)
                .build());
        publisher.publishEvent(new UserCreatedEvent(this, user.getUsername()));
        return user;
    }

    public Optional<User> deleteUser(UUID id) {
        Optional<User> userOptional = repo.findById(id);
        userOptional.ifPresent(user -> {
            repo.delete(user);
            publisher.publishEvent(new UserDeletedEvent(userOptional.get().getUsername(), this));
        });
        return userOptional;
    }

    public List<User> getUsers() {
        return repo.findAll().stream().toList();
    }

    public Optional<User> getUser(UUID id) {
        return repo.findById(id);
    }
}
