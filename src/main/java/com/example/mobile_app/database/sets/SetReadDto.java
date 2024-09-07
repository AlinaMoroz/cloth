package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.users.User;
import lombok.Value;

@Value
public class SetReadDto {
    Long id;

    String description;

    NewsLine newsLine;

    String name;

    User user;
}
