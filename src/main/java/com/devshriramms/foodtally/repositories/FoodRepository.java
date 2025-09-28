package com.devshriramms.foodtally.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.devshriramms.foodtally.models.Food;

public interface FoodRepository extends MongoRepository<Food, String> {
    // Add custom queries if needed
}
