package com.example.mobile_app.database.newslines;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NewsLineService {



    private final NewsLineRepository newsLineRepository;
    private final NewsLineReadMapper newsLineReadMapper;
    private final NewsLineCreateMapper newsLineCreateMapper;

    public Page<NewsLineReadDto> findAllByOrderByLikeCountDesc(Pageable pageable){
        return newsLineRepository.findAllByOrderByLikeCountDesc(pageable)
                .map(newsLineReadMapper::map);
    }



    public Page<NewsLineReadDto> findAllByOrderByPostDateDesc(Pageable pageable){
        return newsLineRepository.findAllByOrderByPostDateDesc(pageable)
                .map(newsLineReadMapper::map);

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
