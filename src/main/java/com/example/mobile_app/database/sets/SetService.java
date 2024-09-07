package com.example.mobile_app.database.sets;

import com.example.mobile_app.database.clothes.ClothRepository;
import com.example.mobile_app.database.sets_clothes.SetCloth;
import com.example.mobile_app.database.sets_clothes.SetClothRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SetService {

    private final SetCreateMapper setCreateMapper;
    private final SetReadMapper setReadMapper;
    private final SetRepository setRepository;
    private final SetUpdateMapper setUpdateMapper;
    private final ClothRepository clothRepository;
    private final SetClothRepository setClothRepository;



    Page<SetReadDto> findByNewsLineId(Long newsLineId, Pageable pageable) {
        return setRepository.findByNewsLineId(newsLineId, pageable)
                .map(setReadMapper::map);
    }


    public Page<SetReadDto> findByUserId(Long userId, Pageable pageable) {
        return setRepository.findByUserId(userId, pageable)
                .map(setReadMapper::map);
    }



    @Transactional
    public Optional<SetReadDto> addClothToSet(Long setId, Long clothId) {
        return setRepository.findById(setId)
                .flatMap(set ->
                        clothRepository.findById(clothId)
                                .map(cloth -> {
                                    SetCloth setCloth = SetCloth.builder()
                                            .cloth(cloth)
                                            .set(set)
                                            .build();
                                    setClothRepository.save(setCloth);
                                    setClothRepository.flush();
                                    set.getSetClothes().add(setCloth);
                                    cloth.getSetClothes().add(setCloth);

                                    return setReadMapper.map(set);
                                })

                );
    }


    public Optional<SetReadDto> findById(Long id) {
        return setRepository.findById(id)
                .map(setReadMapper::map);
    }

    @Transactional
    public Optional<SetReadDto> update(Long id, SetUpdateDto setUpdateDto) {
        return setRepository.findById(id)
                .map(entity -> {
                    setUpdateMapper.map(setUpdateDto, entity);
                    setRepository.save(entity);
                    return setReadMapper.map(entity);
                });
    }

    @Transactional
    public boolean deleteById(Long id) {
        return setRepository.findById(id)
                .map(entity -> {
                    setRepository.delete(entity);
                    setRepository.flush();
                    return true;
                }).orElse(false);


    }

    @Transactional
    public Optional<SetReadDto> create(SetCreateDto setCreateDto) {
        return Optional.ofNullable(setCreateDto)
                .map(setCreateMapper::map)
                .map(setRepository::save)
                .map(setReadMapper::map);

    }


}
