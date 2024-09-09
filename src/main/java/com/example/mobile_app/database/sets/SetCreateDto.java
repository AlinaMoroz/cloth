package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.users.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class SetCreateDto {
    @Size(max = 255)
    String description;

    Long newsLineId;

    @Size(max = 128)
    String name;

    @NotNull
    @Min(0)
    Long userId;
}
