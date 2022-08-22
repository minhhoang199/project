package com.example.webSocketDemo.service;

import com.example.webSocketDemo.model.User;
import com.example.webSocketDemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository accountRepository) {
        this.userRepository = accountRepository;
    }

    public void save(User newUser) {
        if (newUser != null) {
            if (newUser.getUsername() == null ||
                    newUser.getUsername().length() == 0) {
                throw new RuntimeException("Invalid username");
            }
            if (newUser.getPassword() == null ||
                    newUser.getPhone().length() < 8) {
                throw new RuntimeException("Invalid password");
            }
            if (newUser.getPhone() == null ||
                    newUser.getPhone().length() != 10 ||
                    newUser.getPhone().length() != 11) {
                throw new RuntimeException("Invalid phone");
            }
            var userOtp = userRepository.findByPhone(newUser.getPhone());
            if (userOtp.isPresent()) {
                throw new RuntimeException("Phone already existed");
            }
            final String time = new SimpleDateFormat("HH:mm").format(new Date());
            newUser.setCreatedAt(time);
            this.userRepository.save(newUser);
        }
    }

    public User getUserInfo(Long userId) {
        if (userId == null ||
                userId <= 0) {
            throw new RuntimeException("Invalid user Id");
        }
        var userOtp = this.userRepository.findById(userId);
        if (userOtp.isEmpty()) {
            throw new RuntimeException("Not found user");
        }
        return userOtp.get();
    }


    public void updateUserInfo(Long userId, String newUserName, String newUserPhone) {
        if (userId == null ||
                userId <= 0) {
            throw new RuntimeException("Invalid user Id");
        }
        var userOtp = this.userRepository.findById(userId);
        if (userOtp.isEmpty()) {
            throw new RuntimeException("Not found user");
        }

        User currentUser = userOtp.get();


        if (newUserName != null) {
            if (newUserName.length() == 0) {
                throw new RuntimeException("Invalid username");
            }
            currentUser.setUsername(newUserName);
        }

        if (newUserPhone != null) {
            if (newUserPhone.length() != 10 || newUserPhone.length() != 11) {
                throw new RuntimeException("Invalid phone");
            }

            var checkedUserOtp = userRepository.findByPhone(newUserPhone);
            if (checkedUserOtp.isPresent()) {
                throw new RuntimeException("Phone already existed");
            }
            currentUser.setPhone(newUserPhone);
        }
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        currentUser.setUpdatedAt(time);
        this.userRepository.save(currentUser);
    }

    public void changePassword(Long userId, String newPassword) {
        if (userId == null ||
                userId <= 0) {
            throw new RuntimeException("Invalid user Id");
        }

        var userOtp = this.userRepository.findById(userId);
        if (userOtp.isEmpty()) {
            throw new RuntimeException("Not found user");
        }

        User currentUser = userOtp.get();

        if (newPassword != null) {
            if (newPassword.length() < 8) {
                throw new RuntimeException("Invalid password");
            }
            currentUser.setPassword(newPassword);
        }
        this.userRepository.save(currentUser);
    }
}
