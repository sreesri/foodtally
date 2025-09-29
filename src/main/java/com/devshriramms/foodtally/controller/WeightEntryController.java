package com.devshriramms.foodtally.controller;

import com.devshriramms.foodtally.models.WeightEntry;
import com.devshriramms.foodtally.repositories.WeightEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devshriramms.foodtally.dto.WeightHistoryResponse;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/weight")
public class WeightEntryController {
    @Autowired
    private WeightEntryRepository weightEntryRepository;

    @PostMapping
    public WeightEntry addWeightLog(@RequestBody WeightEntry entry) {
        return weightEntryRepository.save(entry);
    }

    @GetMapping("/history/{userId}")
    public WeightHistoryResponse getWeightHistory(@PathVariable String userId) {
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(6);
        LocalDate thirtyDaysAgo = today.minusDays(29);
        LocalDate sixMonthsAgo = today.minusMonths(6).plusDays(1); // inclusive
        LocalDate oneYearAgo = today.minusYears(1).plusDays(1); // inclusive

        var last7 = weightEntryRepository.findByUserIdAndDateBetween(userId, sevenDaysAgo, today);
        var last30 = weightEntryRepository.findByUserIdAndDateBetween(userId, thirtyDaysAgo, today);
        var last6Months = weightEntryRepository.findByUserIdAndDateBetween(userId, sixMonthsAgo, today);
        var lastYear = weightEntryRepository.findByUserIdAndDateBetween(userId, oneYearAgo, today);

        return new WeightHistoryResponse(last7, last30, last6Months, lastYear);
    }
}
