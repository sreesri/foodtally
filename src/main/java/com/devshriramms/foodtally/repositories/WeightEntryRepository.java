package com.devshriramms.foodtally.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.devshriramms.foodtally.models.WeightEntry;

public interface WeightEntryRepository extends MongoRepository<WeightEntry, String> {
    // Add custom queries if needed
    java.util.List<WeightEntry> findByUserIdAndDateBetween(String userId, java.time.LocalDate start,
            java.time.LocalDate end);
}
