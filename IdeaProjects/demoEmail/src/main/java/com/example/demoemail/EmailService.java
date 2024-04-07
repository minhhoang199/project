package com.example.demoemail;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private JavaMailSender mailSender;

    @KafkaListener(groupId = "foodItemGroup", topics = "notification")
    public String sendEmail(String toEmail, String subject, String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("hoangminhst19s99@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);

        this.mailSender.send(simpleMailMessage);
        return "Send !!!";
    }

    @KafkaListener(groupId = "foodItemGroup", topics = "notification")
    public String sendEmailOTP() {
        //"hoangminhst1001@gmail.com", "this is subject", "this is body"
        return "";
    }
}
