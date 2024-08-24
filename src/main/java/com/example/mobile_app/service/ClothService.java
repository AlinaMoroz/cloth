package com.example.mobile_app.service;

import com.example.mobile_app.database.clothes.Type;
import com.example.mobile_app.database.clothes.ClothRepository;
import com.example.mobile_app.database.users.UserRepository;
import com.example.mobile_app.database.clothes.ClothCreateDto;
import com.example.mobile_app.database.clothes.ClothReadDto;
import com.example.mobile_app.database.clothes.ClothCreateMapper;
import com.example.mobile_app.database.clothes.ClothReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ClothService {

    private final ClothRepository clothRepository;
    private final UserRepository userRepository;
    private final ClothCreateMapper clothCreateMapper;
    private final ClothReadMapper clothReadMapper;

    @Transactional
    public ClothReadDto create(ClothCreateDto createDto){
        return Optional.of(createDto)
                .map(clothCreateMapper::map)
                .map(clothRepository::save)
                .map(clothReadMapper::map)
                .orElseThrow();
    }

//    public List<ClothReadDto> findAllByUserIdAndType(Long userId, Type type){
//        var user = userRepository.findById(userId).orElseThrow();
//        return clothRepository.findAllByUserAndType(user, type)
//                .stream()
//                .map(clothReadMapper::map).collect(Collectors.toList());
//
//
//    }





}
