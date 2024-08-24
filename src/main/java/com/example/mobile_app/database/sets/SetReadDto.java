package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.newslines.NewsLine;
import lombok.Value;

@Value
public class SetReadDto {
    Long id;

    String description;

    NewsLine newsLine;

    String name;
}
