package com.devshriramms.foodtally;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDate;
import java.util.List;

public interface CalorieEntryRepository extends MongoRepository<CalorieEntry, String> {
    List<CalorieEntry> findByUserIdAndDate(String userId, LocalDate date);

    List<CalorieEntry> findByUserId(String userId);
}
