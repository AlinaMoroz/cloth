package com.example.mobile_app.integration.database.repository;

import com.example.mobile_app.database.clothes.Type;
import com.example.mobile_app.database.clothes.ClothRepository;
import com.example.mobile_app.database.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
class ClothRepositoryTest {
    private final ClothRepository clothRepository;
    private final UserRepository userRepository;
//    private final SetRepository setRepository;

//    @Test
//    void findAllByUserAndType() {
//        var user = userRepository.findById(1L).orElseThrow();
//        assertNotNull(user);
//        var byUserAndType = clothRepository.findAllByUserAndType(user, Type.DRESS);
//        Assertions.assertThat(byUserAndType).hasSize(1);
//
//    }

//    @Test
//    void findAllByUserAndSet(){
//        var set = setRepository.findById(1L);
//        assertNotNull(set);
//        var user = userRepository.findById(1L);
//        assertNotNull(user);
//
//        var clothSet = clothRepository.findAllByUserAndSet(user, set);
//        Assertions.assertThat(clothSet).hasSize(2);
//    }
}