package com.example.chatWebsocket.service;

import com.example.chatWebsocket.model.Connection;
import com.example.chatWebsocket.model.User;
import com.example.chatWebsocket.model.enums.ConnectionStatus;
import com.example.chatWebsocket.model.vm.RequestConnectionVM;
import com.example.chatWebsocket.repository.ConnectionRepository;
import com.example.chatWebsocket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConnectionService {
    private ConnectionRepository connectionRepository;
    private UserRepository userRepository;

    public ConnectionService(ConnectionRepository connectionRepository, UserRepository userRepository) {
        this.connectionRepository = connectionRepository;
        this.userRepository = userRepository;
    }

    public void createConnection(RequestConnectionVM requestConnectionVM) {
        String followingPhone = requestConnectionVM.getFollowingPhone();
        if (followingPhone == null ||
                followingPhone.length() != 10 &&
                        followingPhone.length() != 11) {
            throw new RuntimeException("Invalid requestPhone");
        }

        String followedPhone = requestConnectionVM.getFollowedPhone();
        if (followedPhone == null ||
                followedPhone.length() != 10 &&
                        followedPhone.length() != 11) {
            throw new RuntimeException("Invalid followedPhone");
        }

        Optional<Connection> otpConnection = this.connectionRepository.findByUsers(followingPhone, followedPhone);
        if (otpConnection.isPresent()) {
            throw new RuntimeException("Connection already existed");
        }

        Optional<User> otpFollowingUser = this.userRepository.findByPhone(followingPhone);
        if (otpFollowingUser.isEmpty()) {
            throw new RuntimeException("Not found following user");
        }

        Optional<User> otpFollowedUser = this.userRepository.findByPhone(followedPhone);
        if (otpFollowedUser.isEmpty()) {
            throw new RuntimeException("Not found followed user");
        }

        Connection newConnection = new Connection();
        newConnection.setFollowedUser(otpFollowedUser.get());
        newConnection.setFollowingUser(otpFollowingUser.get());
        newConnection.setConnectionStatus(ConnectionStatus.CONNECTED);

        connectionRepository.save(newConnection);
    }
}
