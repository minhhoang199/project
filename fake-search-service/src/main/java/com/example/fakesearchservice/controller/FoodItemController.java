package com.example.fakesearchservice.controller;

import com.example.fakesearchservice.model.FoodItemDTO;
import com.example.fakesearchservice.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foodItems/")
public class FoodItemController {
    @Autowired
    private FoodItemService foodItemService;

//    @GetMapping("{id}")
//    public FoodItemDTO getFoodItemDetail(@PathVariable int id){
//        return this.foodItemService.getById(id);
//    }
}
