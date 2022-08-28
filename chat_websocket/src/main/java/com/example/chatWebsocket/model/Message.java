package com.example.chatWebsocket.model;


import com.example.chatWebsocket.model.enums.MessageStatus;
import com.example.chatWebsocket.model.enums.MessageType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    @JsonIgnoreProperties(value = {"messages"}, allowSetters = true)
    private User sender;

    @Column(name = "content", nullable = false)
    private String content;

    @Enumerated(EnumType.STRING)
    private MessageType type;

    @Column(name = "created_at", nullable = false)
    private String createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "message_status", nullable = false)
    private MessageStatus messageStatus;

    @ManyToOne
    @JoinColumn(name = "conversation_id")
    @JsonIgnoreProperties(value = {"messages"}, allowSetters = true)
    private Conversation conversation;

    @Column(name = "created_by", length = 200)
    private String createdBy;

    @Column(name = "created_date")
    private Long createdDate;

    @Column(name = "modified_by", length = 200)
    private String modifiedBy;

    @Column(name = "modified_date")
    private Long modifiedDate;
}