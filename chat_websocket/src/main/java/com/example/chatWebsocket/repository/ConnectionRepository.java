package com.example.chatWebsocket.repository;

import com.example.chatWebsocket.model.Connection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
    @Query("SELECT c FROM Connection c Where c.followingUser.phone = ?1 AND c.followedUser.phone = ?2")
    public Optional<Connection> findByUsers(String followingPhone, String followedPhone);
}
