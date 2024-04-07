//package com.example.fakesearchservice;
//
//import org.apache.kafka.clients.consumer.*;
//import org.apache.kafka.common.TopicPartition;
//import org.apache.kafka.common.serialization.StringDeserializer;
//
//import java.time.Duration;
//import java.util.*;
//
//public class CheckCommiyedOffset {
//    public static void main(String[] args) {
//        // Set up consumer properties
//        Properties props = new Properties();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(ConsumerConfig.GROUP_ID_CONFIG, "foodItemGroup");
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
//
//        // Create KafkaConsumer
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//
//        // Subscribe to topics
//        TopicPartition partition = new TopicPartition("foodItem", 0);
//        consumer.assign(Collections.singletonList(partition));
//
//        // Seek to the end of the partition
//        consumer.seekToEnd(Collections.singleton(partition));
//
//        // Get the current offset
//        OffsetAndMetadata committedOffset = consumer.committed(partition);
//
//        // Print the current offset
//        System.out.println("Current offset: " + committedOffset);
//
//        // Print the last committed offset
//        if (committedOffset != null) {
//            System.out.println("Last Committed Offset: " + committedOffset.offset());
//        } else {
//            System.out.println("No committed offset found for the partition.");
//        }
//
////        consumer.assign(Arrays.asList(new TopicPartition("foodItem", 0)));
////        consumer.seekToEnd(Arrays.asList(new TopicPartition("foodItem", 0)));
////
////
////        ConsumerRecords<String, String> records;
////
////        do {
////            records = consumer.poll(Duration.ofSeconds(1));
////            System.out.println("currentPosition" + consumer.position(new TopicPartition("foodItem", 0)));
////            for (ConsumerRecord<String, String> record : records) {
////                long currentPosition = consumer.position(new TopicPartition(record.topic(), record.partition()));
////                System.out.println("topic " + record.topic() + " partition " + record.partition());
////                if (currentPosition > record.offset()) {
////                    // The record has been committed
////                    // Add your logic here
////                    System.out.println("Record offset " + record.offset() + " has been committed");
////                } else {
////                    // The record has not been committed
////                    // Add your logic here
////                    System.out.println("Record offset " + record.offset() + " has not been committed");
////                }
////            }
////        } while (!records.isEmpty());
//
//        consumer.close();
//    }
//}
