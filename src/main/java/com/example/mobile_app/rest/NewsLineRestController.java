package com.example.mobile_app.rest;

import com.example.mobile_app.database.newslines.NewsLineCreateDto;
import com.example.mobile_app.database.newslines.NewsLineReadDto;
import com.example.mobile_app.database.newslines.NewsLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/news-lines")
public class NewsLineRestController {

    private final NewsLineService newsLineService;
    private static final Integer pageSize = 5;



    @GetMapping("/sortLikeCount/{page}")
    public Page<NewsLineReadDto> findAllByOrderedByLikeCount(@PathVariable Integer page){
        return newsLineService.findAllByOrderByLikeCountDesc(PageRequest.of(page, pageSize));

    }

    @GetMapping("/sortPostDate/{page}")
    public Page<NewsLineReadDto> findAllByOrderedByPostDateDesc(@PathVariable Integer page){
        return newsLineService.findAllByOrderByPostDateDesc(PageRequest.of(page, pageSize));

    }

    @GetMapping("/{id}")
    public NewsLineReadDto findById(@PathVariable Long id){
        return newsLineService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  NewsLineReadDto create(@RequestBody @Validated NewsLineCreateDto newsLineCreateDto){
        return newsLineService.create(newsLineCreateDto);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if (!newsLineService.deleteById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


}
