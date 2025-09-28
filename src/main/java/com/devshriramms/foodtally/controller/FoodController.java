package com.devshriramms.foodtally.controller;

import com.devshriramms.foodtally.models.Food;
import com.devshriramms.foodtally.repositories.FoodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }

    @PutMapping("/{id}")
    public Food updateFood(@PathVariable String id, @RequestBody Food food) {
        food.setId(id);
        return foodRepository.save(food);
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Food> getFoodById(@PathVariable String id) {
        return foodRepository.findById(id);
    }
}
