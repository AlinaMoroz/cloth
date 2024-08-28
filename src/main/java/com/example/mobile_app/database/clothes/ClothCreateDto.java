package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.clothes.Season;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import com.example.mobile_app.database.clothes.Type;
import com.example.mobile_app.database.users.User;
import lombok.Value;

@Value
public class ClothCreateDto {
    Long userId;
    String linkPhoto;
    Season season;
    Type type;
}
