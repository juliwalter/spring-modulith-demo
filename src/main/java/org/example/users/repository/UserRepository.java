package org.example.users.repository;

import org.example.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repository managing user entities
 *
 * @author julianwalter
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
