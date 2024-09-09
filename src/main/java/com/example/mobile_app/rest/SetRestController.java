package com.example.mobile_app.rest;

import com.example.mobile_app.database.sets.SetCreateDto;
import com.example.mobile_app.database.sets.SetReadDto;

import com.example.mobile_app.database.sets.SetService;
import com.example.mobile_app.database.sets.SetUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/sets")
public class SetRestController {

    private final SetService setService;
    private static final Integer pageSize = 5;
    @GetMapping("/newsLines/{id}/{page}")
    public Page<SetReadDto> findByNewsLineId(@PathVariable Long id, @PathVariable Integer page){
        return setService.findByNewsLineId(id, PageRequest.of(page, pageSize));
    }
    @GetMapping("/users/{id}/{page}")
    public Page<SetReadDto> findByUserId(@PathVariable Long id, @PathVariable Integer page){
        return setService.findByUserId(id, PageRequest.of(page,pageSize));
    }

    @PostMapping("/sets/{setId}/clothes/{clothId}")
    public SetReadDto addClothToSet(@PathVariable Long setId, @PathVariable Long clothId){
        return setService.addClothToSet(setId, clothId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Set or Cloth not found"));

    }

    @GetMapping("/{id}")
    public SetReadDto findById(@PathVariable Long id) {
        return setService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Set not found"));
    }

    @PutMapping("/{id}")
    public SetReadDto update(@PathVariable Long id, @Validated @RequestBody SetUpdateDto setUpdateDto){
        return setService.update(id,setUpdateDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        if(!setService.deleteById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public SetReadDto create(@Validated @RequestBody SetCreateDto setCreateDto) {
        return setService.create(setCreateDto);
    }

}
