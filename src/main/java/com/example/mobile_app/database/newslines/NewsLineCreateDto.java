package com.example.mobile_app.database.newslines;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewsLineCreateDto {
    @PastOrPresent
    LocalDateTime postData;

    @NotNull
    @Min(0)
    Integer likeCount;

    @NotNull
    @Min(0)
    Integer dislikeCount;

}
