
package com.devshriramms.foodtally.controller;

import com.devshriramms.foodtally.models.IntakeEntry;
import com.devshriramms.foodtally.repositories.IntakeEntryRepository;
import com.devshriramms.foodtally.dto.CalorieStatsResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.time.LocalDate;

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

    @GetMapping("/stats/{userId}")
    public CalorieStatsResponse getCalorieStats(
            @PathVariable String userId,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "year", required = false) Integer year) {
        // Calculate date ranges
        LocalDate today = LocalDate.now();
        LocalDate sevenDaysAgo = today.minusDays(6);
        LocalDate thirtyDaysAgo = today.minusDays(29);

        // Last 7 days
        List<IntakeEntry> last7Days = intakeRepository.findByUserIdAndDateBetween(userId, sevenDaysAgo, today);
        int total7 = last7Days.stream().mapToInt(IntakeEntry::getCalories).sum();
        double avg7 = last7Days.isEmpty() ? 0 : (double) total7 / 7;

        // Last 30 days
        List<IntakeEntry> last30Days = intakeRepository.findByUserIdAndDateBetween(userId, thirtyDaysAgo, today);
        int total30 = last30Days.stream().mapToInt(IntakeEntry::getCalories).sum();
        double avg30 = last30Days.isEmpty() ? 0 : (double) total30 / 30;

        // For a particular month
        Integer m = month;
        Integer y = year;
        int totalMonth = 0;
        double avgMonth = 0;
        if (m != null && y != null) {
            LocalDate start = LocalDate.of(y, m, 1);
            LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
            List<IntakeEntry> monthEntries = intakeRepository.findByUserIdAndDateBetween(userId, start, end);
            totalMonth = monthEntries.stream().mapToInt(IntakeEntry::getCalories).sum();
            avgMonth = monthEntries.isEmpty() ? 0 : (double) totalMonth / start.lengthOfMonth();
        }

        return new CalorieStatsResponse(total7, avg7, total30, avg30, totalMonth, avgMonth);
    }

    // ...existing code...
}
