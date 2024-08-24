package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.clothes.Cloth;
import com.example.mobile_app.database.general.Mapper;
import com.example.mobile_app.database.clothes.ClothCreateDto;
import org.springframework.stereotype.Component;

@Component
public class ClothCreateMapper implements Mapper<ClothCreateDto, Cloth> {
    @Override
    public Cloth map(ClothCreateDto object) {
        return Cloth.builder()
                .user(object.getUser())
                .linkPhoto(object.getLinkPhoto())
                .season(object.getSeason())
                .type(object.getType())
                .build();
    }
}
