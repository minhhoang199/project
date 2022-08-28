package com.example.chatWebsocket.repository;

import com.example.chatWebsocket.model.Conversation;
import com.example.chatWebsocket.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    @Query("SELECT DISTINCT c FROM Conversation c INNER JOIN c.users u where u.id = ?1")
    List<Conversation> findByUserId(Long userId);

    @Query("SELECT DISTINCT  c FROM Conversation c INNER JOIN c.users u WHERE u.id = ?1 " +
            "AND c.name LIKE %?2%")
    List<Conversation> findByUserIdAndChatName(Long userId, String name);
}