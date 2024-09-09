package com.example.mobile_app.database.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class UserCreateDto {
    @NotNull
    @Size(min = 1, max = 128)
    String name;

    @Email
    @Size(max = 255)
    String email;

    @NotNull
    @Size(min = 6, max = 255)
    String password;


    @Size(max = 255)
    String avatar;
}
