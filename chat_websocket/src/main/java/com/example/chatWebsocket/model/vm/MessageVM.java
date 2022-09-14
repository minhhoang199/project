package com.example.chatWebsocket.model.vm;

import com.example.chatWebsocket.model.enums.MessageStatus;
import com.example.chatWebsocket.model.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageVM {
    private String sender;
    private String content;
    private MessageType messageType;
    private MessageStatus messageStatus;
}
