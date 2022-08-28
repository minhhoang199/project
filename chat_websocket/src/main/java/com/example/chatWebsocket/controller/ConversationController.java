package com.example.chatWebsocket.controller;

import com.example.chatWebsocket.model.Conversation;
import com.example.chatWebsocket.service.ConversationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/conversations")
public class ConversationController {
    private ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping
    public ResponseEntity<List<Conversation>> getAll(){
        return ResponseEntity.ok(conversationService.getAll());
    }

    @PostMapping()
    public ResponseEntity<Conversation> createConversation(
            @RequestBody Conversation newPrivateChat
    ) {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        newPrivateChat.setCreatedAt(time);
        Conversation rs = conversationService.save(newPrivateChat);
        return ResponseEntity.ok(rs);
    }

    @PostMapping("/{conversationId}")
    public ResponseEntity<Conversation> addAccounts(
            @PathVariable("conversationId") Long chatId,
            @RequestParam("firstPhone") String firstPhone,
            @RequestParam("secondPhone") String secondPhone
    ){
        Conversation chat = conversationService.addAccount(firstPhone, secondPhone, chatId);
        return ResponseEntity.ok(chat);
    }
}
