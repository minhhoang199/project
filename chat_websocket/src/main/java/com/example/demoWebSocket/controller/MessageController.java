package com.example.demoWebSocket.controller;


import com.example.demoWebSocket.model.Message;
import com.example.demoWebSocket.model.PrivateMessage;
import com.example.demoWebSocket.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {
    private SimpMessagingTemplate messagingTemplate;
    private MessageService messageService;

    public MessageController(SimpMessagingTemplate messagingTemplate, MessageService messageService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
    }

    @MessageMapping("/chat_register")
    @SendTo("/topic/messages")
    public Message register(@Payload Message message, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }


    @MessageMapping("/chat_send")
//    @SendTo("/topic/public")
    public PrivateMessage sendMessage(@Payload Message message) {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        PrivateMessage privateMessage = new PrivateMessage(message.getSender(), message.getContent(), message.getType(), time);
        messageService.saveMessage(privateMessage);
        messagingTemplate.convertAndSend("/topic/messages", privateMessage);
        return privateMessage;
    }
}
