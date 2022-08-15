package com.example.demoWebSocket.controller;

import com.example.demoWebSocket.model.Account;
import com.example.demoWebSocket.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("")
    public ResponseEntity<String> addNewAccount(@RequestBody Account newAccount){
        accountService.save(newAccount);
        return ResponseEntity.ok("Create successful");
    }
}
