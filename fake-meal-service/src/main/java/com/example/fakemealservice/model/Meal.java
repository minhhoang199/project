package com.example.fakemealservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String mealName;
    private String foodItemList;
}
