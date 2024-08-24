package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.clothes.Cloth;
import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.clothes.ClothReadDto;
import com.example.mobile_app.database.users.UserReadDto;
import com.example.mobile_app.database.users.UserReadMapper;
import com.example.mobile_app.database.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClothReadMapper implements Mapper<Cloth, ClothReadDto> {

    private final UserReadMapper userReadMapper;


    @Override
    public ClothReadDto map(Cloth object) {

        var userReadDto = Optional.ofNullable(object.getUser())
                .map(userReadMapper::map)
                .orElse(null);

        return new ClothReadDto(object.getId(),
                userReadDto,
                object.getLinkPhoto(),
                object.getSeason(),
                object.getType());
    }


}
