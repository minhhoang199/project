package com.example.demoemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoEmailApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoEmailApplication.class, args);
    }
}
