package com.example.mobile_app.database.users;

import com.example.mobile_app.database.general.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {

        return new UserReadDto(object.getId(),
                object.getName(),
                object.getEmail(),
                object.getPassword(),
                object.getAvatar());
    }
}
