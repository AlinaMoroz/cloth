package com.example.mobile_app.database.users;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    // TODO: 26.08.2024 fix update method

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateMapper userCreateMapper;

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);

    }

    @Transactional
    public boolean deleteById(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
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
    public UserReadDto update(Long id, UserCreateDto userCreateDto) {
        return userRepository.findById(id).map(
                entity -> {
                    entity.setName(userCreateDto.getName());
                    entity.setAvatar(userCreateDto.getAvatar());
                    entity.setEmail(userCreateDto.getEmail());
                    entity.setPassword(userCreateDto.getPassword());
                    var entity1 = userRepository.save(entity);
                    userRepository.flush();
                    return userReadMapper.map(entity1);
                }

        ).orElseThrow();
    }

    public boolean userExist(Long id) {
        return userRepository.existsById(id);
    }

}
