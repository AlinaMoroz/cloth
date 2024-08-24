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
    private final NewsLineRepository newsLineRepository;
    private final NewsLineReadMapper newsLineReadMapper;
    private final NewsLineCreateMapper newsLineCreateMapper;


    // TODO: 21.08.2024  add Pageable
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


}
