package com.example.demoWebSocket.service;
import com.example.demoWebSocket.model.PrivateMessage;
import com.example.demoWebSocket.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(PrivateMessage privateMessage){
        if (privateMessage != null){
            messageRepository.save(privateMessage);
        }
    }
}
