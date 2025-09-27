package com.devshriramms.foodtally;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/calories")
public class CalorieEntryController {

    @Autowired
    private CalorieEntryRepository repository;

    @PostMapping
    public CalorieEntry addEntry(@RequestBody CalorieEntry entry) {
        if (entry.getDate() == null) {
            entry.setDate(LocalDate.now());
        }
        return repository.save(entry);
    }

    @GetMapping("/{userId}")
    public List<CalorieEntry> getEntriesForUser(@PathVariable String userId,
            @RequestParam(required = false) String date) {
        if (date != null) {
            return repository.findByUserIdAndDate(userId, LocalDate.parse(date));
        }
        return repository.findByUserId(userId);
    }
}
