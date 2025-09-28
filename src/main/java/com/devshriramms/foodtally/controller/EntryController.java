package com.devshriramms.foodtally.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devshriramms.foodtally.models.IntakeEntry;
import com.devshriramms.foodtally.repositories.IntakeEntryRepository;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/calories")
public class EntryController {

    @Autowired
    private IntakeEntryRepository repository;

    @PostMapping
    public IntakeEntry addEntry(@RequestBody IntakeEntry entry) {
        if (entry.getDate() == null) {
            entry.setDate(LocalDate.now());
        }
        return repository.save(entry);
    }

}
