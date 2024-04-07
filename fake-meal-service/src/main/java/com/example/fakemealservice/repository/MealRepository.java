package com.example.fakemealservice.repository;

import com.example.fakemealservice.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends JpaRepository<Meal, String> {
}
