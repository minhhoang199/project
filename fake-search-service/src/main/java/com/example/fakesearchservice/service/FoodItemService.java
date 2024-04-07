package com.example.fakesearchservice.service;

import com.example.fakesearchservice.exception.DataNotFoundException;
import com.example.fakesearchservice.model.FoodItem;
import com.example.fakesearchservice.model.FoodItemDTO;
import com.example.fakesearchservice.model.SMSRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.TopicPartition;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
public class FoodItemService implements ConsumerSeekAware {
    private JavaMailSender mailSender;
//    private FoodItemRepository foodItemRepository;
//    private RedisTemplate template;

//    @Override
//    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
//        assignments.forEach(((topicPartition, offset) -> callback.seekToEnd(topicPartition.topic(), topicPartition.partition())));
//    }

//    @KafkaListener(groupId = "foodItemGroup", topics = "foodItem")
//    public void saveFoodItem(List<FoodItemDTO> foodItemDTOList) {
//        System.out.println("Data from Kafka: " + foodItemDTOList);
////        FoodItem foodItem = new FoodItem();
////        foodItem.setFoodItemName(object.getFoodItemName());
////        System.out.println(foodItem.toString());
////        this.foodItemRepository.save(foodItem);
//
//        if (foodItemDTOList != null && !foodItemDTOList.isEmpty()) {
//            List<FoodItem> newListFoodItem = foodItemDTOList.stream().map(foodItemDTO -> {
//                FoodItem foodItem = new FoodItem();
//                foodItem.setFoodItemName(foodItemDTO.getFoodItemName());
//                return foodItem;
//            }).collect(Collectors.toList());
//            this.foodItemRepository.saveAll(newListFoodItem);
//        }
//
////        acknowledgment.acknowledge();
//    }

    @KafkaListener(groupId = "foodItemGroup", topics = "notification")
    public void getOTP(SMSRequest smsRequest) {
        System.out.println("Data from Kafka Notification: " + smsRequest);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("hoangminhst19s99@gmail.com");
        simpleMailMessage.setTo("hoangminhst1001@gmail.com");
        simpleMailMessage.setSubject("Send OTP from system");
        simpleMailMessage.setText("This is your OTP: " + smsRequest.getCode());

        this.mailSender.send(simpleMailMessage);
        }

//        acknowledgment.acknowledge();

//    @KafkaListener(id = "foodItemRollbackGroup", topics = "foodItemRollBack")
//    public void rollBackFoodItem(List<FoodItemDTO> foodItemDTOList) {
//        System.out.println("Rollback: " + foodItemDTOList);
////        FoodItem foodItem = new FoodItem();
////        foodItem.setFoodItemName(object.getFoodItemName());
////        System.out.println(foodItem.toString());
////        this.foodItemRepository.save(foodItem);
//        List<FoodItem> rollBackListFoodItem = new ArrayList<>();
//
//        if (foodItemDTOList != null && !foodItemDTOList.isEmpty()) {
//            foodItemDTOList.stream().forEach(foodItemDTO -> {
//                Optional<FoodItem> optionalFoodItem = this.foodItemRepository.findByFoodItemName(foodItemDTO.getFoodItemName());
//                if (optionalFoodItem.isPresent()){
//                    log.info("foodItem exists:" + optionalFoodItem.get());
//                    rollBackListFoodItem.add(optionalFoodItem.get());
//                }
//            });
//            this.foodItemRepository.deleteAll(rollBackListFoodItem);
//        }
//    }

//    public FoodItemDTO getById(Integer id) {
//        try {
//            final String key = "foodItem_" + id;
//            Optional<FoodItem> optionalFoodItem = this.foodItemRepository.findById(id);
//            final ValueOperations<String, FoodItemDTO> operations = template.opsForValue();
//            final boolean hasKey = template.hasKey(key);
////            System.out.println(1/0);
//            if (hasKey) {
//                System.out.println("This is data from Redis");
//                return operations.get(key);
//            }
//            if (optionalFoodItem.isPresent()) {
//                FoodItemDTO rs = new FoodItemDTO(optionalFoodItem.get().getFoodItemName());
//                operations.set(key, rs);
//                System.out.println("This is data from Database MySQL");
//                return rs;
//            }
//        } catch (Exception e) {
//            log.error("Data not found");
//            throw new DataNotFoundException("Data not found");
//        }
//
//        return null;
//    }
}
