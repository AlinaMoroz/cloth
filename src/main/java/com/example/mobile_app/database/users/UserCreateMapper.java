package com.example.mobile_app.database.users;

import com.example.mobile_app.database.general.Mapper;
import org.springframework.stereotype.Component;

@Component
public class UserCreateMapper implements Mapper<UserCreateDto, User> {
    @Override
    public User map(UserCreateDto object) {
        return User.builder()
                .name(object.getName())
                .email(object.getEmail())
                .password(object.getPassword())
                .avatar(object.getAvatar())
                .build();
    }
}
