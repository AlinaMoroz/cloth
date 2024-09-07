package com.example.mobile_app.database.users;

import com.example.mobile_app.database.general.MapperUpdate;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapper implements MapperUpdate<UserUpdateDto,User> {
    @Override
    public User map(UserUpdateDto object, User toObject) {
        toObject.setPassword(object.getPassword());
        toObject.setName(object.getName());
        toObject.setAvatar(object.getAvatar());
        toObject.setSize(object.getSize());
        return toObject;
    }
}
