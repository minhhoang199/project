package com.example.fakesearchservice.configuration;

import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.converter.JsonMessageConverter;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {
    @Bean
    JsonMessageConverter converter(){
        return new JsonMessageConverter();
    }

    // Kafka Consumer Configuration
//    @Bean
//    public ConsumerFactory<String, String> consumerFactory() {
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "foodItemGroup");
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                ByteArrayDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                ByteArrayDeserializer.class);
//
//        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new StringDeserializer());
//    }
//
//    // Kafka Listener Container Factory
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory());
//        factory.getContainerProperties().setSyncCommits(true);
//        factory.getContainerProperties().setMissingTopicsFatal(false);
//
//        return factory;
//    }

}
