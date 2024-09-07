package com.example.mobile_app.database.users;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateMapper userCreateMapper;
    private final UserUpdateMapper userUpdateMapper;

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);

    }

    @Transactional
    public boolean deleteById(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    return true;
                }).orElse(false);

    }

    public Optional<UserReadDto> findByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateDto userDto) {
        return Optional.of(userDto)
                .map(userCreateMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public UserReadDto update(Long id, UserUpdateDto userUpdateDto) {
        return userRepository.findById(id).map(
                entity -> {
                    var user = userUpdateMapper.map(userUpdateDto, entity);
                    var entity1 = userRepository.save(user);
                    userRepository.flush();
                    return userReadMapper.map(entity1);
                }

        ).orElseThrow();
    }

    public boolean userExist(Long id) {
        return userRepository.existsById(id);
    }

}
