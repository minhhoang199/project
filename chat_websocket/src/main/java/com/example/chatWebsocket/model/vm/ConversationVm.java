package com.example.chatWebsocket.model.vm;

import com.example.chatWebsocket.model.enums.ConversationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConversationVm {
    private String name;
    private List<String> phones;
    private ConversationType conversationType;
    private String invitorPhone;
}
