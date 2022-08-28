package com.example.chatWebsocket.service;

import com.example.chatWebsocket.model.Conversation;
import com.example.chatWebsocket.repository.UserRepository;
import com.example.chatWebsocket.repository.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConversationService {
    private ConversationRepository privateChatRepository;
    private UserRepository accountRepository;

    public ConversationService(ConversationRepository privateChatRepository, UserRepository accountRepository) {
        this.privateChatRepository = privateChatRepository;
        this.accountRepository = accountRepository;
    }


    public Conversation save(Conversation newChat) {
        if (newChat != null) {
            this.privateChatRepository.save(newChat);
        }
        return newChat;
    }

    public List<Conversation> getAll(){
        return privateChatRepository.findAll();
    }

    public Conversation addAccount(String firstPhone, String secondPhone, Long chatId) {
        var optChat = privateChatRepository.findById(chatId);
        var optFirstAccount = accountRepository.findByPhone(firstPhone);
        var optSecondAccount = accountRepository.findByPhone(secondPhone);
        if (optFirstAccount.isEmpty() || optSecondAccount.isEmpty()) {
            throw new RuntimeException("Not found account");
        }

        var firstAccount = optFirstAccount.get();
        var secondAccount = optSecondAccount.get();

        if (optChat.isPresent()){
            Conversation chat = optChat.get();
            chat.getUsers().add(firstAccount);
            chat.getUsers().add(secondAccount);
            this.privateChatRepository.save(chat);
            return chat;
        } else {
            throw new RuntimeException("Not found private chat");
        }
    }
}
