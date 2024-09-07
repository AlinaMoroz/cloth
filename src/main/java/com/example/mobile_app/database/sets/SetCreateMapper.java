package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.newslines.NewsLine;
import com.example.mobile_app.database.newslines.NewsLineRepository;
import com.example.mobile_app.database.users.User;
import com.example.mobile_app.database.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class SetCreateMapper implements Mapper<SetCreateDto,Set> {

    private final NewsLineRepository newsLineRepository;
    private final UserRepository userRepository;

    @Override
    public Set map(SetCreateDto object) {
        var newsLine = newsLineRepository.findById(object.getNewsLineId())
                .orElse(null);
        var user = userRepository.findById(object.getUserId())
                .orElse(null);

        return Set.builder()
                .description(object.getDescription())
                .newsLine(newsLine)
                .name(object.getName())
                .user(user)
                .build();
    }
}
