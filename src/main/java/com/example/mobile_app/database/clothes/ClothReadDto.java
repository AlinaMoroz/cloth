package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.clothes.Season;
import com.example.mobile_app.database.clothes.Type;
import com.example.mobile_app.database.users.User;
import com.example.mobile_app.database.users.UserReadDto;
import lombok.Value;

@Value
public class ClothReadDto {
    Long id;
    UserReadDto userReadDto;
    String linkPhoto;
    Season season;
    Type type;
}
