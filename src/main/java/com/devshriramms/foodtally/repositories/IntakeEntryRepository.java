package com.devshriramms.foodtally.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devshriramms.foodtally.models.IntakeEntry;

import java.time.LocalDate;
import java.util.List;

public interface IntakeEntryRepository extends MongoRepository<IntakeEntry, String> {
    List<IntakeEntry> findByUserIdAndDate(String userId, LocalDate date);

    List<IntakeEntry> findByUserId(String userId);

    List<IntakeEntry> findByUserIdAndDateBetween(String userId, LocalDate start, LocalDate end);
}
