package com.example.mobile_app.rest;

import com.example.mobile_app.database.users.UserCreateDto;
import com.example.mobile_app.database.users.UserReadDto;
import com.example.mobile_app.database.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserRestController {


    private final UserService userService;

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable  Long id){
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        if(! userService.deleteById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/by-email")
    public UserReadDto findByEmail(@RequestParam String email){
        return userService.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@RequestBody UserCreateDto userCreateDto){
        return userService.create(userCreateDto);

    }




}
