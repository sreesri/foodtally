package com.devshriramms.foodtally.controller;

import com.devshriramms.foodtally.models.WeightEntry;
import com.devshriramms.foodtally.repositories.WeightEntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weight")
public class WeightEntryController {
    @Autowired
    private WeightEntryRepository weightEntryRepository;

    @PostMapping
    public WeightEntry addWeightLog(@RequestBody WeightEntry entry) {
        return weightEntryRepository.save(entry);
    }
}
