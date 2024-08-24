package com.example.mobile_app.service;

import com.example.mobile_app.database.sets_clothes.SetClothRepository;
import com.example.mobile_app.database.users.UserRepository;
//import com.example.mobile_app.dto.SetClothCreateDto;
//import com.example.mobile_app.dto.SetClothReadDto;
//import com.example.mobile_app.mapper.SetClothCreateMapper;
//import com.example.mobile_app.mapper.SetClothReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SetClothService {
//
//    private final SetClothRepository setClothRepository;
//    private final SetClothCreateMapper setClothCreateMapper;
//    private final SetClothReadMapper setClothReadMapper;
//
//    private final UserRepository userRepository;
//
//
//    @Transactional
//    public SetClothReadDto create(SetClothCreateDto setClothCreateDto){
//        return Optional.of(setClothCreateDto)
//                .map(setClothCreateMapper::map)
//                .map(setClothRepository::save)
//                .map(setClothReadMapper::map)
//                .orElseThrow();
//    }
//
//    public List<SetClothReadDto> findAllByUserId(Long id) {
//        return setClothRepository.findAllByUserId(id)
//                .stream()
//                .map(setClothReadMapper::map)
//                .collect(Collectors.toList());
//
//    }


}
