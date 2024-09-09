package com.example.mobile_app.database.sets;

import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class SetUpdateDto {
    @Size(max = 255)
    String description;

    @Size(max = 128)
    String name;
}
