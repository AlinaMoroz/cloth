package com.example.mobile_app.database.comments;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class CommentUpdateDto {
    @NotNull
    @Size(max = 512)
    String text;
}
