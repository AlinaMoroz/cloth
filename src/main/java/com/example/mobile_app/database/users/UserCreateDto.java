package com.example.mobile_app.database.users;

import lombok.Value;

@Value
public class UserCreateDto {
    String name;
    String email;
    String password;
    String avatar;
}
