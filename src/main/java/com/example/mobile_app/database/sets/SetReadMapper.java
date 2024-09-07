package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.general.Mapper;
import org.springframework.stereotype.Component;

@Component
public class SetReadMapper implements Mapper<Set, SetReadDto> {
    @Override
    public SetReadDto map(Set object) {
        return new SetReadDto(object.getId(),
                object.getDescription(),
                object.getNewsLine(),
                object.getName(),
                object.getUser());
    }
}
