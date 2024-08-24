package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import com.example.mobile_app.database.users.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CommentCreateDto {


    Long userId;

    String text;

    LocalDateTime datePost;

    Long newsLineId;
}
