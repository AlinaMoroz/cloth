package com.example.mobile_app.database.users;

import jakarta.persistence.Column;
import lombok.Value;

@Value
public class UserUpdateDto {

    private String name;

    private String email;

    private String password;

    private String avatar;

    private String size;
}
