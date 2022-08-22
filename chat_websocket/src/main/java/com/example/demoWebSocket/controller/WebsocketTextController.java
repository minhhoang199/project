package com.example.webSocketDemo.controller;

import com.example.webSocketDemo.model.Message;
import com.example.webSocketDemo.service.MessageService;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebsocketTextController {
    private MessageService messageService;
    private SimpMessageSendingOperations messagingTemplate;

    public WebsocketTextController(MessageService messageService, SimpMessageSendingOperations messagingTemplate) {
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendMessage/{conversationId}/users/{senderId}")
    public Message sendMessage(@Payload Message message,
                               @DestinationVariable Long conversationId,
                               @DestinationVariable Long senderId){
        messagingTemplate.convertAndSend("/topic/public/" + conversationId, message);
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        message.setCreatedAt(time);
        messageService.saveMessage(message, senderId, conversationId);
        return message;
    }
}
