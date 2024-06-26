package com.example.toDo.repeository;

import com.example.toDo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByPhone(String phone);
    Optional<User> findByKeyCloakId(String keyCloakId);
    Boolean existsByUsername(String username);
}
