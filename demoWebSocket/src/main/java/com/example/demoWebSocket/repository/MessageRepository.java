package com.example.demoWebSocket.repository;

import com.example.demoWebSocket.model.PrivateMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<PrivateMessage, Long> {
}
