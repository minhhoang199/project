package com.example.fakemealservice.controller;

import com.example.fakemealservice.model.Meal;
import com.example.fakemealservice.model.dto.MealDTO;
import com.example.fakemealservice.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/meals")
@AllArgsConstructor
public class MealController {
    private MealService mealService;

    @PostMapping
    public MealDTO addMeal(@RequestBody MealDTO mealDTO){
        if(this.mealService.addMeal(mealDTO)){
            return mealDTO;
        }
        return null;
    }
}
