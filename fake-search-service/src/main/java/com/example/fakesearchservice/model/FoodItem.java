package com.example.fakesearchservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//import org.springframework.data.redis.core.RedisHash;

//import javax.persistence.*;

@AllArgsConstructor
@Data
@NoArgsConstructor
//@Entity
//@Table(name = "food_item")
public class FoodItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private int id;

//    @Column(name = "food_item_name")
    private String foodItemName;
}
