package com.example.mobile_app.database.clothes;


import jakarta.validation.constraints.*;
import lombok.Value;

@Value
public class ClothCreateDto {
    @NotNull
    @Positive
    Long userId;

    @NotBlank
    @Size(max = 255)
    String linkPhoto;

    @NotNull
    Season season;

    @NotNull
    Type type;
}
