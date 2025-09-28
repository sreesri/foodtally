package com.devshriramms.foodtally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devshriramms.foodtally.models.IntakeEntry;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/calories")
public class EntryController {

    @Autowired
    private CalorieEntryRepository repository;

    @PostMapping
    public IntakeEntry addEntry(@RequestBody IntakeEntry entry) {
        if (entry.getDate() == null) {
            entry.setDate(LocalDate.now());
        }
        return repository.save(entry);
    }

}
