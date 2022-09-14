package com.example.chatWebsocket.model.vm;

import com.example.chatWebsocket.model.enums.ConversationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrivateConversationVM {
    private String name;
    private String invitorPhone;
    private String inviteePhone;
}
