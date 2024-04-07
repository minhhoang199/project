package com.example.fakemealservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class MealDTO {
    private String mealName;
    private List<FoodItemDTO> foodItems;
}
