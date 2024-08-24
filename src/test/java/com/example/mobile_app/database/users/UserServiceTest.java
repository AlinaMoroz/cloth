package com.example.mobile_app.database.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void findById() {
    }

    @Test
    void findByEmail(){
        String email = "alice.smirnova@example.com";
        var userByEmail = userService.findByEmail(email);
        assertTrue(userByEmail.isPresent());


    }
    @Test
    void  deleteById(){
        Long id = 10L;
        assertTrue(userService.deleteById(id));

    }

    @Test
    void create() {

        UserCreateDto userCreateDto = new UserCreateDto("Павел Беля3",
                "belkaPav2df@mail.ru",
                "password",
                "D:");

        var userReadDto = userService.create(userCreateDto);
        assertEquals("belkaPav2df@mail.ru", userReadDto.getEmail());

    }
}