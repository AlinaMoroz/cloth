package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.newslines.NewsLineReadDto;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import com.example.mobile_app.database.users.User;
import com.example.mobile_app.database.users.UserReadDto;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class CommentReadDto {
    Long id;

    UserReadDto userReadDto;

    String text;

    LocalDateTime datePost;



}
