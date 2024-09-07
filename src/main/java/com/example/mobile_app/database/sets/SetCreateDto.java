package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.users.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Value;

@Value
public class SetCreateDto {
    String description;

    Long newsLineId;

    String name;

    Long userId;
}
