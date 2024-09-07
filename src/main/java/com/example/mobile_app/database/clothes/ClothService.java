package com.example.mobile_app.database.clothes;

import com.example.mobile_app.database.sets_clothes.SetClothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ClothService {



    private final ClothRepository clothRepository;
    private final ClothReadMapper clothReadMapper;
    private final ClothCreateMapper clothCreateMapper;
    private final SetClothRepository setClothRepository;

    public Optional<ClothReadDto>findById(Long id){
        return clothRepository.findById(id)
                .map(clothReadMapper::map);
    }
    public List<ClothReadDto>findAllClothBySetId(Long setId){

        return setClothRepository.findAllClothBySetId(setId)
                .stream()
                .map(clothReadMapper::map)
                .toList();
    }

    @Transactional
    public Optional<ClothReadDto> create(ClothCreateDto createDto){
        return Optional.of(createDto)
                .map(clothCreateMapper::map)
                .map(clothRepository::save)
                .map(clothReadMapper::map);

    }

    public List<ClothReadDto>findAllByUserIdAndType(Long userId, Type type){
        return clothRepository.findAllByUserIdAndType(userId, type)
                .stream().map(clothReadMapper::map).toList();

    }

    @Transactional
    public boolean deleteById(Long id){
        return clothRepository.findById(id)
                .map(entity ->{
                    clothRepository.delete(entity);
                    clothRepository.flush();
                    return true;
                })
                .orElse(false);

    }
}
