package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.newslines.NewsLineReadDto;
import com.example.mobile_app.database.newslines.NewsLineReadMapper;
import com.example.mobile_app.database.users.UserReadDto;
import com.example.mobile_app.database.users.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentReadMapper implements Mapper<Comment, CommentReadDto> {

    private final UserReadMapper userReadMapper;


    @Override
    public CommentReadDto map(Comment object) {
        var userReadDto = Optional.ofNullable(object.getUser())
                .map(userReadMapper::map)
                .orElse(null);
        return new CommentReadDto(object.getId(),
                userReadDto,
                object.getText(),
                object.getDatePost());
    }
}
