package com.example.mobile_app.database.comments;

import com.example.mobile_app.database.newslines.NewsLineRepository;
import com.example.mobile_app.database.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentCreateMapper commentCreateMapper;
    private final CommentRepository commentRepository;
    private final CommentReadMapper commentReadMapper;
    private final NewsLineRepository newsLineRepository;
    private final UserService userService;


    @Transactional
    public CommentReadDto create(CommentCreateDto createDto) {
        return Optional.of(createDto)
                .map(commentCreateMapper::map)
                .map(commentRepository::save)
                .map(commentReadMapper::map)
                .orElseThrow();
    }


    public List<CommentReadDto> findAllByNewsLineId(Long newsLineId) {

//                var userReadDto = Optional.ofNullable(object.getUser())
//                .map(userReadMapper::map)
//                .orElse(null);


        return commentRepository.findAllByNewsLineId(newsLineId)
                .stream()
                .map(commentReadMapper::map)
                .toList();

    }

    @Transactional
    public Boolean deleteById(Long id) {
        return commentRepository.findById(id)
                .map(entity -> {
                    commentRepository.delete(entity);
                    commentRepository.flush();
                    return true;
                }).orElse(false);
    }

//    public CommentReadDto update()


}
