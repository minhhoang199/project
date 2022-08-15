package com.example.demoWebSocket.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "shop_message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrivateMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "sender", length = 50, nullable = false)
    private String sender;
    @Column(name = "content", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageType type;
    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @ManyToOne
    @JoinColumn(name = "private_chat_id", referencedColumnName = "id")
    @JsonManagedReference
    private PrivateChat privateChat;

    public PrivateMessage(String sender, String content, MessageType type, String created_at) {
        this.sender = sender;
        this.content = content;
        this.type = type;
        this.createdAt = created_at;
    }
}
