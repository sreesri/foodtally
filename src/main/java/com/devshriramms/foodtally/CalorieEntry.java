package com.devshriramms.foodtally;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "calorie_entries")
public class CalorieEntry {
    @Id
    private String id;
    private String userId;
    private String foodName;
    private int calories;
    private LocalDate date;
}
