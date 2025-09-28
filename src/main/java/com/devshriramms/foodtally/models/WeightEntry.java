package com.devshriramms.foodtally.models;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "weight_entry")
public class WeightEntry {

    @Id
    String id;
    String userId;
    double weight;
    LocalDate date;
}
