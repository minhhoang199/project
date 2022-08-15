package com.example.demoWebSocket.service;

import com.example.demoWebSocket.model.Account;
import com.example.demoWebSocket.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void save(Account newAccount){
        if (newAccount != null){
            var accountOtp = accountRepository.findByPhone(newAccount.getPhone());
            if (accountOtp.isPresent()){
                throw new RuntimeException("Phone already existed");
            }
            this.accountRepository.save(newAccount);
        }
    }
}
