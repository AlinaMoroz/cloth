package com.example.mobile_app.database.clothes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClothService {

    // TODO: 26.08.2024 add method create 
    // TODO: 26.08.2024 add method findById
    // TODO: 26.08.2024 add method delete 
    // TODO: 26.08.2024 add method findAllClothBySetId 

    private final ClothRepository clothRepository;
    private final ClothReadMapper clothReadMapper;
    private final ClothCreateMapper clothCreateMapper;

//    public ClothReadDto create(ClothCreateDto createDto){
//        Optional.of(createDto)
//                .map(clothCreateMapper::map)
//                .map()
//
//    }

    public List<ClothReadDto>findAllByUserIdAndType(Long userId, Type type){
        return clothRepository.findAllByUserIdAndType(userId, type)
                .stream().map(clothReadMapper::map).toList();

    }
}
