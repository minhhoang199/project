package com.example.webSocketDemo.controller;

import com.example.webSocketDemo.model.Message;
import com.example.webSocketDemo.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages(@RequestParam("content") String content){
        var ret = this.messageService.getAllMessage(content);
        return ResponseEntity.ok(ret);
    }

    @PatchMapping("/{messageId}")
    public ResponseEntity<String> editMessage(@PathVariable("messageId") Long messageId,
                                              @RequestBody String newContent){
        this.messageService.editMessage(messageId, newContent);
        return ResponseEntity.ok("Update succeed");
    }

    @PatchMapping("/{messageId}/status")
    public ResponseEntity<String> deactiveMessage(@PathVariable("messageId") Long messageId){
        this.messageService.deactiveMessage(messageId);
        return ResponseEntity.ok("Deactive message succeed");
    }
}
