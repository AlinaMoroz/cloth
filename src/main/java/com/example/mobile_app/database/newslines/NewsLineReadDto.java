package com.example.mobile_app.database.newslines;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class NewsLineReadDto {

    Long id;
    LocalDateTime postData;
    Integer likeCount;
    Integer dislikeCount;

}
