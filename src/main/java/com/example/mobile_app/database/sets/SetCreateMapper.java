package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.general.Mapper;
import org.springframework.stereotype.Component;

@Component
public class SetCreateMapper implements Mapper<SetCreateDto,Set> {
    @Override
    public Set map(SetCreateDto object) {
        return Set.builder()
                .description(object.getDescription())
                .newsLine(object.getNewsLine())
                .name(object.getName())
                .build();
    }
}
