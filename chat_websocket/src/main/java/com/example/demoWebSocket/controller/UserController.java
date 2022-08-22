package com.example.webSocketDemo.controller;

import com.example.webSocketDemo.model.User;
import com.example.webSocketDemo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody User newUser){
        this.userService.save(newUser);
        return ResponseEntity.ok("Add new user succeed");
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<String> editUserInfo(
            @PathVariable("userId") Long userId,
            @RequestParam(name = "username", required = false) String username,
            @RequestParam(name = "phone", required = false) String phone
            ){
        this.userService.updateUserInfo(userId, username, phone);
        return ResponseEntity.ok("Update succeed");
    }

    @PatchMapping("/{userId}/password")
    public ResponseEntity<String> changePassword(
            @PathVariable("userId") Long userId,
            @RequestParam(name = "password") String password
    ){
        this.userService.changePassword(userId, password);
        return ResponseEntity.ok("Change password succeed");
    }

}
