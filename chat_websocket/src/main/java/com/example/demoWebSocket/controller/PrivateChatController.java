package com.example.demoWebSocket.controller;

import com.example.demoWebSocket.service.PrivateChatService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivateChatController {
    private PrivateChatService privateChatService;

    public PrivateChatController(PrivateChatService privateChatService) {
        this.privateChatService = privateChatService;
    }


}
