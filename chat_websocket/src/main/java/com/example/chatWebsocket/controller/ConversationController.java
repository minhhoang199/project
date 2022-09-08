package com.example.chatWebsocket.controller;

import com.example.chatWebsocket.model.Conversation;
import com.example.chatWebsocket.model.enums.ConversationStatus;
import com.example.chatWebsocket.model.vm.ConversationVm;
import com.example.chatWebsocket.model.vm.InviteeVm;
import com.example.chatWebsocket.service.ConversationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conversations")
public class ConversationController {
    private ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @GetMapping
    public ResponseEntity<List<Conversation>> getAll() {
        return ResponseEntity.ok(conversationService.getAll());
    }

    @PostMapping()
    public ResponseEntity<String> createConversation(
            @RequestBody ConversationVm conversationVm
    ) {
        this.conversationService.addNewConversation(conversationVm);
        return ResponseEntity.ok("Create conversation succeed");
    }

    @PostMapping("/{conversationId}")
    public ResponseEntity<String> addAccounts(
            @PathVariable("conversationId") Long conversationId,
            @RequestBody InviteeVm inviteeVm
    ) {
        this.conversationService.addMoreUser(inviteeVm, conversationId);
        return ResponseEntity.ok("Add more users succeed");
    }

    @PatchMapping("/{conversationId}")
    public ResponseEntity<String> changeStatus(
            @PathVariable("conversationId") Long conversationId,
            @RequestBody ConversationStatus conversationStatus
    ){
        this.conversationService.changeConversationStatus(conversationId, conversationStatus);
        return ResponseEntity.ok("Change conversation status succeed");
    }
}