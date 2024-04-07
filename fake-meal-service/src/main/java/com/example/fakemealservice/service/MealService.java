package com.example.fakemealservice.service;

import com.example.fakemealservice.model.FoodItem;
import com.example.fakemealservice.model.Meal;
import com.example.fakemealservice.model.dto.FoodItemDTO;
import com.example.fakemealservice.model.dto.MealDTO;
import com.example.fakemealservice.repository.MealRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MealService {
    private MealRepository mealRepository;
    private ModelMapper modelMapper;
    private KafkaTemplate<String, Object> kafkaTemplate;


    @Transactional
    public boolean addMeal(MealDTO mealDTO) {
        try {
            Meal newMeal = new Meal();
            newMeal.setMealName(mealDTO.getMealName());
            newMeal.setFoodItemList(mealDTO.getFoodItems().toString());
            if (this.mealRepository.save(newMeal) != null) {
    //            mealDTO.getFoodItems().forEach(foodItem -> {
    //                this.kafkaTemplate.send("foodItem", foodItem);
    //                System.out.println(foodItem);
    //            });
                this.kafkaTemplate.send("foodItem", mealDTO.getFoodItems());
                System.out.println(1/0);
                System.out.println(mealDTO.getFoodItems());
                return true;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            this.kafkaTemplate.send("foodItemRollBack", mealDTO.getFoodItems());
        }
        return false;
    }
}
