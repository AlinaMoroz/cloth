package com.example.mobile_app.database.clothes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClothService {

    private final ClothRepository clothRepository;
    private final ClothReadMapper clothReadMapper;

    public List<ClothReadDto>findAllByUserIdAndType(Long userId, Type type){
        return clothRepository.findAllByUserIdAndType(userId, type)
                .stream().map(clothReadMapper::map).toList();

    }
}
