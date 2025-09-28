package com.devshriramms.foodtally.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "food")
public class Food {

    @Id
    String id;
    String name;
    int caloriesPerServing;

}
