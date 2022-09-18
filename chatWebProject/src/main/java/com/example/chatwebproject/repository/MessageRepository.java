package com.example.chatwebproject.repository;

import com.example.chatwebproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE m.content LIKE %?1%")
    List<Message> findByContentContaining(String content);
}
