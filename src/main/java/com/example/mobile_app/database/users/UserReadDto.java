package com.example.mobile_app.database.users;

import lombok.Value;

@Value
public class UserReadDto {
    Long id;
    String name;
    String email;
    String password;
    String avatar;
}
