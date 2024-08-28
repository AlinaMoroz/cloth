package com.example.mobile_app.database.newslines;

import com.example.mobile_app.database.newslines.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class NewsLineService {


    // TODO: 26.08.2024 fix method findAll to findAllByOrderByPostDateDesc + add Pageable
    // TODO: 26.08.2024 add method findAllByOrderByLikeDesc + add Pageable


    private final NewsLineRepository newsLineRepository;
    private final NewsLineReadMapper newsLineReadMapper;
    private final NewsLineCreateMapper newsLineCreateMapper;



    public List<NewsLineReadDto> findAll(){
        return newsLineRepository.findAll()
                .stream()
                .map(newsLineReadMapper::map)
                .collect(Collectors.toList());

    }

    public Optional<NewsLineReadDto>findById(Long id){
        return newsLineRepository.findById(id)
                .map(newsLineReadMapper::map);
    }

    @Transactional
    public NewsLineReadDto create(NewsLineCreateDto createDto){
        return Optional.of(createDto)
                .map(newsLineCreateMapper::map)
                .map(newsLineRepository::save)
                .map(newsLineReadMapper::map)
                .orElseThrow();

    }

    @Transactional
    public boolean deleteById(Long id){
        return newsLineRepository.findById(id)
                .map(entity ->{
                    newsLineRepository.delete(entity);
                    newsLineRepository.flush();
                    return true;
                })
                .orElse(false);
    }


}
