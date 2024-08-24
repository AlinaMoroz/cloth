package com.example.mobile_app.database.newslines;

import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.newslines.NewsLineReadDto;
import org.springframework.stereotype.Component;

@Component
public class NewsLineReadMapper implements Mapper<NewsLine, NewsLineReadDto> {

    @Override
    public NewsLineReadDto map(NewsLine object) {
        return new NewsLineReadDto(object.getId(),
                object.getPostDate(),
                object.getLikeCount(),
                object.getDislikeCount());
    }
}
