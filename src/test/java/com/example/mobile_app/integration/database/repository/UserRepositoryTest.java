package com.example.mobile_app.integration.database.repository;

import com.example.mobile_app.database.users.UserRepository;
import lombok.RequiredArgsConstructor;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@Transactional
@RequiredArgsConstructor
@SpringBootTest
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void findById(){

        var user = userRepository.findById(1L);
        Assertions.assertThat(user.get().getName()).isEqualTo("Алиса Смирнова");

        assertNotNull(user);

    }





    @Test
    void findAll(){
        var users = userRepository.findAll();
        Assertions.assertThat(users).hasSize(3);
    }

}