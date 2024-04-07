package com.example.fakemealservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class FoodItem {

    private String id;
    private String foodItemName;
}
