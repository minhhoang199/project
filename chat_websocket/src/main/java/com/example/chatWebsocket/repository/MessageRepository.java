package com.example.chatWebsocket.repository;

import com.example.chatWebsocket.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.content LIKE %?1%")
    List<Message> findByContentContaining(String content);
}
