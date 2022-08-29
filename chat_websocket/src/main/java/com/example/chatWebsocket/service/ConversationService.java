package com.example.chatWebsocket.service;

import com.example.chatWebsocket.model.Conversation;
import com.example.chatWebsocket.model.User;
import com.example.chatWebsocket.model.enums.ConversationType;
import com.example.chatWebsocket.model.vm.ConversationVm;
import com.example.chatWebsocket.repository.ConversationRepository;
import com.example.chatWebsocket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ConversationService {
    private ConversationRepository conversationRepository;
    private UserRepository accountRepository;

    public ConversationService(ConversationRepository privateChatRepository, UserRepository accountRepository) {
        this.conversationRepository = privateChatRepository;
        this.accountRepository = accountRepository;
    }


    public void addNewConversation(ConversationVm conversationVm) {
        if (conversationVm != null) {
            String name = conversationVm.getName();
            if (name == null ||
                    name.length() <= 1) {
                throw new RuntimeException("Invalid name");
            }

            ConversationType conversationType = conversationVm.getConversationType();
            if (conversationType == null) {
                throw new RuntimeException("Invalid conversation type");
            }

            List<String> phones = conversationVm.getPhones();
            if (phones == null ||
                    (conversationType == ConversationType.PRIVATE_CHAT && phones.size() != 2) ||
                    (conversationType == ConversationType.GROUP_CHAT && phones.size() < 2)) {
                throw new RuntimeException("Invalid list of phones");
            }

            Conversation newConversation = new Conversation();
            newConversation.setName(name);
            newConversation.setConversationType(conversationType);

            Set<User> users = new HashSet<>();
            for (String phone : phones
            ) {
                if (phone == null ||
                        phone.length() != 10 &&
                                phone.length() != 11) {
                    throw new RuntimeException("Invalid phone");
                }

                Optional<User> optionalUser= this.accountRepository.findByPhone(phone);
                if (optionalUser.isEmpty()){
                    throw new RuntimeException("Not found account by phone");
                }
                User currentUser = optionalUser.get();
                currentUser.getConversations().add(newConversation);
                this.accountRepository.save(currentUser);
                users.add(currentUser);
            }
            newConversation.setUsers(users);
            this.conversationRepository.save(newConversation);
        }
    }

    public List<Conversation> getAll() {
        return conversationRepository.findAll();
    }

    public void addMoreUser(List<String> phones, Long conversationId) {
        var optConversation = conversationRepository.findById(conversationId);
        if (optConversation.isEmpty()){
            throw new RuntimeException("Not found conversation");
        } else if (optConversation.get().getConversationType() == ConversationType.PRIVATE_CHAT){
            throw new RuntimeException("Invalid conversation Type: private chat can not add more users");
        }
        Conversation currentConversation = optConversation.get();
        Set<User> users = currentConversation.getUsers();

        for (String phone : phones
        ) {
            if (phone == null ||
                    phone.length() != 10 &&
                            phone.length() != 11) {
                throw new RuntimeException("Invalid phone");
            }

            Optional<User> optionalUser= this.accountRepository.findByPhone(phone);
            if (optionalUser.isEmpty()){
                throw new RuntimeException("Not found account by phone");
            }
            User currentUser = optionalUser.get();
            currentUser.getConversations().add(currentConversation);
            this.accountRepository.save(currentUser);
            users.add(currentUser);
        }
        currentConversation.setUsers(users);
        this.conversationRepository.save(currentConversation);
    }
}
