package com.example.mobile_app.database.newslines;

import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.newslines.NewsLineCreateDto;
import org.springframework.stereotype.Component;

@Component
public class NewsLineCreateMapper implements Mapper<NewsLineCreateDto, NewsLine> {
    @Override
    public NewsLine map(NewsLineCreateDto object) {
        return NewsLine.builder()
                .postDate(object.getPostData())
                .likeCount(object.getLikeCount())
                .dislikeCount(object.getDislikeCount())
                .build();
    }
}
