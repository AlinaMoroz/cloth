package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.clothes.Cloth;
import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.clothes.ClothCreateDto;
import com.example.mobile_app.database.users.User;
import com.example.mobile_app.database.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClothCreateMapper implements Mapper<ClothCreateDto, Cloth> {

    private final UserRepository userRepository;
    @Override
    public Cloth map(ClothCreateDto object) {
        var user = Optional.ofNullable(object.getUserId())
                .flatMap(userRepository::findById)
                .orElse(null);

        return Cloth.builder()
                .user(user)
                .linkPhoto(object.getLinkPhoto())
                .season(object.getSeason())
                .type(object.getType())
                .build();
    }
}
