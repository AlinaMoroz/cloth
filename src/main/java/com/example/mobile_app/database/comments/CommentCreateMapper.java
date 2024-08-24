package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.newslines.NewsLineRepository;
import com.example.mobile_app.database.users.User;
import com.example.mobile_app.database.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CommentCreateMapper implements Mapper<CommentCreateDto, Comment> {

    private final NewsLineRepository newsLineRepository;
    private final UserRepository userRepository;

    @Override
    public Comment map(CommentCreateDto object) {
        return Comment.builder()
                .user(getUser(object.getUserId()))
                .text(object.getText())
                .datePost(object.getDatePost())
                .newsLine(getNewsLine(object.getNewsLineId()))
                .build();
    }

    private NewsLine getNewsLine(Long newsLineId){
        return Optional.ofNullable(newsLineId)
                .flatMap(newsLineRepository::findById)
                .orElse(null);
    }

    private User getUser(Long userId){
        return Optional.ofNullable(userId)
                .flatMap(userRepository::findById)
                .orElse(null);

    }
}
