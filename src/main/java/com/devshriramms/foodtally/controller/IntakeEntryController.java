package com.devshriramms.foodtally.controller;

import com.devshriramms.foodtally.models.IntakeEntry;
import com.devshriramms.foodtally.repositories.IntakeEntryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/intake")
public class IntakeEntryController {
    @Autowired
    private IntakeEntryRepository intakeRepository;

    @PostMapping
    public IntakeEntry createIntakeEntry(@RequestBody IntakeEntry entry) {
        return intakeRepository.save(entry);
    }

    @PutMapping("/{id}")
    public IntakeEntry updateIntakeEntry(@PathVariable String id, @RequestBody IntakeEntry entry) {
        entry.setId(id);
        return intakeRepository.save(entry);
    }

    @GetMapping("/{id}")
    public Optional<IntakeEntry> getIntakeEntry(@PathVariable String id) {
        return intakeRepository.findById(id);
    }
}
