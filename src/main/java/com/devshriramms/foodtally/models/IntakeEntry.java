package com.devshriramms.foodtally.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.devshriramms.foodtally.enums.FoodCategory;
import com.devshriramms.foodtally.enums.Meal;

import java.time.LocalDate;

@Data
@Document(collection = "intake_entry")
public class IntakeEntry {

    @Id
    String id;
    String userId;
    String foodName;
    Food food;
    FoodCategory category;
    Meal meal;
    int calories;
    LocalDate date;
}
