package com.example.demoWebSocket.service;

import com.example.demoWebSocket.model.PrivateChat;
import org.springframework.stereotype.Service;

@Service
public class PrivateChatService {
    private PrivateChatService privateChatService;

    public PrivateChatService(PrivateChatService privateChatService) {
        this.privateChatService = privateChatService;
    }

    public void save(PrivateChat newChat){
        if (newChat != null){
            this.privateChatService.save(newChat);
        }
    }
}
