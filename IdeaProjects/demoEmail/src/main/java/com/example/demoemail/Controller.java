package com.example.demoemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emails")
public class Controller {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public String send() {
        this.emailService.sendEmail("hoangminhst1001@gmail.com", "this is subject", "this is body");
        return "2st";
    }

}
