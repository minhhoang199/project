package com.example.demoWebSocket.repository;

import com.example.demoWebSocket.model.PrivateChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivateChatRepository extends JpaRepository<PrivateChat, Long> {
}
