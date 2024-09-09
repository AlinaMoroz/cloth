package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import com.example.mobile_app.database.users.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CommentCreateDto {

    @NotNull
    @Positive
    Long userId;

    @NotNull
    @Max(512)
    String text;
    @PastOrPresent
    LocalDateTime datePost;

    @NotNull
    @Positive
    Long newsLineId;
}
