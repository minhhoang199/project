package com.example.fakemealservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicKafkaConfig {
    @Bean
    public NewTopic addFoodItemTopic(){
        return new NewTopic("foodItem", 1, (short) 1);
    }

    @Bean
    public NewTopic addFoodItemRollBackTopic(){
        return new NewTopic("foodItemRollBack", 1, (short) 1);
    }
}
