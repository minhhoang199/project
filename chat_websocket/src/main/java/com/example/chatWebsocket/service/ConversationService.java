package com.example.chatWebsocket.service;

import com.example.chatWebsocket.model.Connection;
import com.example.chatWebsocket.model.Conversation;
import com.example.chatWebsocket.model.User;
import com.example.chatWebsocket.model.enums.ConnectionStatus;
import com.example.chatWebsocket.model.enums.ConversationStatus;
import com.example.chatWebsocket.model.enums.ConversationType;
import com.example.chatWebsocket.model.vm.ConversationVm;
import com.example.chatWebsocket.model.vm.InviteeVm;
import com.example.chatWebsocket.repository.ConnectionRepository;
import com.example.chatWebsocket.repository.UserRepository;
import com.example.chatWebsocket.repository.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

@Service
public class ConversationService {
    private ConversationRepository conversationRepository;
    private UserRepository userRepository;
    private ConnectionRepository connectionRepository;

    public ConversationService(ConversationRepository conversationRepository,
                               UserRepository accountRepository,
                               ConnectionRepository connectionRepository) {
        this.conversationRepository = conversationRepository;
        this.userRepository = accountRepository;
        this.connectionRepository = connectionRepository;
    }

    public void addNewConversation(ConversationVm conversationVm) {
        if (conversationVm != null) {
            //validation
            String name = conversationVm.getName();
            if (name == null ||
                    name.length() <= 1) {
                throw new RuntimeException("Invalid name");
            }

            Optional<User> optionalInvitor = this.userRepository.findByPhone(conversationVm.getInvitorPhone());
            if (optionalInvitor.isEmpty()) {
                throw new RuntimeException("Not found invitor");
            }

            User invitor = optionalInvitor.get();

            ConversationType conversationType = conversationVm.getConversationType();
            if (conversationType == null) {
                throw new RuntimeException("Invalid conversation type");
            }
            List<String> phones = conversationVm.getPhones();
            if (phones == null ||
                    (conversationType == ConversationType.PRIVATE_CHAT && phones.size() != 1) ||
                    (conversationType == ConversationType.GROUP_CHAT && phones.size() < 2)) {
                throw new RuntimeException("Invalid list of phones");
            }

            Conversation newConversation = new Conversation();
            newConversation.setName(name);
            newConversation.setConversationType(conversationType);

            //add invitor to the list
            Set<User> users = new HashSet<>();
            invitor.getConversations().add(newConversation);
            this.userRepository.save(invitor);
            users.add(invitor);

            //add users to the list
            if (conversationType == ConversationType.PRIVATE_CHAT) {
                String inviteePhone = phones.get(0);

                if (inviteePhone == null ||
                        inviteePhone.length() != 10 &&
                                inviteePhone.length() != 11) {
                    throw new RuntimeException("Invalid phone");
                }

                Optional<User> optionalInvitee = this.userRepository.findByPhone(inviteePhone);
                if (optionalInvitee.isEmpty()) {
                    throw new RuntimeException("Not found account by invitee phone");
                }

                Optional<Connection> optionalConnectionWithInvitee = this.connectionRepository.findByUsersAndStatus(
                        conversationVm.getInvitorPhone(),
                        inviteePhone,
                        ConnectionStatus.CONNECTED);
                Optional<Connection> optionalConnectionWithInvitor = this.connectionRepository.findByUsersAndStatus(
                        inviteePhone,
                        conversationVm.getInvitorPhone(),
                        ConnectionStatus.CONNECTED);

                if (optionalConnectionWithInvitor.isPresent() || optionalConnectionWithInvitee.isPresent()) {
                    throw new RuntimeException("Private chat already exist");
                }

                User invitee = optionalInvitee.get();
                invitee.getConversations().add(newConversation);
                this.userRepository.save(invitee);
                users.add(invitee);

                Connection connectionWithInvitee = new Connection();
                connectionWithInvitee.setFollowingUser(invitor);
                connectionWithInvitee.setFollowedUser(invitee);
                connectionWithInvitee.setConnectionStatus(ConnectionStatus.CONNECTED);

                this.connectionRepository.save(connectionWithInvitee);
            } else {
                for (String phone : phones
                ) {
                    if (phone == null ||
                            phone.length() != 10 &&
                                    phone.length() != 11) {
                        throw new RuntimeException("Invalid phone");
                    }

                    Optional<User> optionalUser = this.userRepository.findByPhone(phone);
                    if (optionalUser.isEmpty()) {
                        throw new RuntimeException("Not found account by phone");
                    }

                    Optional<Connection> optionalConnectionWithUser = this.connectionRepository.findByUsersAndStatus(
                            conversationVm.getInvitorPhone(),
                            phone,
                            ConnectionStatus.CONNECTED);
                    Optional<Connection> optionalConnectionWithInvitor = this.connectionRepository.findByUsersAndStatus(
                            phone,
                            conversationVm.getInvitorPhone(),
                            ConnectionStatus.CONNECTED);
                    if (optionalConnectionWithInvitor.isEmpty() || optionalConnectionWithUser.isEmpty()) {
                        throw new RuntimeException("Invalid connection between invitor and User");
                    }

                    User currentUser = optionalUser.get();
                    currentUser.getConversations().add(newConversation);
                    this.userRepository.save(currentUser);
                    users.add(currentUser);
                }
            }

            newConversation.setUsers(users);
            newConversation.setConversationStatus(ConversationStatus.ENABLE);
            this.conversationRepository.save(newConversation);
        }
    }

    public List<Conversation> getAll() {
        return conversationRepository.findAll();
    }

    public void addMoreUser(InviteeVm inviteeVm, Long conversationId) {
        String invitorPhone = inviteeVm.getInvitorPhone();
        if (invitorPhone == null ||
                invitorPhone.length() != 10 &&
                        invitorPhone.length() != 11) {
            throw new RuntimeException("Invalid phone");
        }

        Optional<User> optionalInvitor = this.userRepository.findByPhone(invitorPhone);
        if (optionalInvitor.isEmpty()) {
            throw new RuntimeException("Not found invitor");
        }
        User invitor = optionalInvitor.get();

        var optConversation = conversationRepository.findById(conversationId);
        if (optConversation.isEmpty()) {
            throw new RuntimeException("Not found conversation");
        } else if (optConversation.get().getConversationType() == ConversationType.PRIVATE_CHAT) {
            throw new RuntimeException("Invalid conversation Type: private chat can not add more users");
        }
        Conversation currentConversation = optConversation.get();
        Set<User> users = currentConversation.getUsers();

        List<String> inviteePhones = inviteeVm.getInviteePhones();
        for (String phone : inviteePhones
        ) {
            if (phone == null ||
                    phone.length() != 10 &&
                            phone.length() != 11) {
                throw new RuntimeException("Invalid phone");
            }

            Optional<User> optionalUser = this.userRepository.findByPhone(phone);
            if (optionalUser.isEmpty()) {
                throw new RuntimeException("Not found account by phone " + phone);
            }
            Optional<Connection> optionalConnectionWithUser = this.connectionRepository.findByUsersAndStatus(
                    invitorPhone,
                    phone,
                    ConnectionStatus.CONNECTED);
            Optional<Connection> optionalConnectionWithInvitor = this.connectionRepository.findByUsersAndStatus(
                    phone,
                    invitorPhone,
                    ConnectionStatus.CONNECTED);
            if (optionalConnectionWithInvitor.isEmpty() || optionalConnectionWithUser.isEmpty()) {
                throw new RuntimeException("Invalid connection between invitor and User");
            }

            User currentUser = optionalUser.get();

            currentUser.getConversations().add(currentConversation);
            this.userRepository.save(currentUser);
            users.add(currentUser);
        }
        currentConversation.setUsers(users);
        this.conversationRepository.save(currentConversation);
    }

    public void changeConversationStatus(Long id, ConversationStatus conversationStatus){
        if (id == null || id <= 0){
            throw new RuntimeException("Invalid Id");
        }

        Optional<Conversation> optionalConversation = this.conversationRepository.findById(id);
        if (optionalConversation.isEmpty()){
            throw new RuntimeException("Not found conversation");
        }

        Conversation currentConversation = optionalConversation.get();
        currentConversation.setConversationStatus(conversationStatus);
        this.conversationRepository.save(currentConversation);
    }
}