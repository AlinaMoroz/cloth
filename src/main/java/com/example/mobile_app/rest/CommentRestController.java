package com.example.mobile_app.rest;

import com.example.mobile_app.database.comments.CommentCreateDto;
import com.example.mobile_app.database.comments.CommentReadDto;
import com.example.mobile_app.database.comments.CommentService;
import com.example.mobile_app.database.comments.CommentUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comments")
public class CommentRestController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public CommentReadDto findById(@PathVariable Long id){
        return commentService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public CommentReadDto update(@PathVariable Long id, @RequestBody @Validated CommentUpdateDto commentUpdateDto){
        return commentService.update(id, commentUpdateDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentReadDto create(@RequestBody @Validated CommentCreateDto commentCreateDto){
        return commentService.create(commentCreateDto);

    }

    @GetMapping("/newsLines/{id}")
    public List<CommentReadDto> findAllByNewsLineId(@PathVariable Long id){
        return commentService.findAllByNewsLineId(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        if(!commentService.deleteById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }




}
