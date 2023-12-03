package com.example.service;

import com.example.dto.UserDto;
import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository repository;

    public List<UserDto> getUsers() {
        List<UserEntity> allUsers = repository.findAll();
        return allUsers.stream().map(this::toDto).toList();
    }

    public UserDto saveUser(String userName) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(userName);

        UserEntity persisted = repository.save(userEntity);
        log.info("User [" + userName + "] has been persisted. User id is [" + persisted.getId() + "]");
        return toDto(persisted);
    }

    private UserDto toDto(UserEntity persisted) {
        return new UserDto(persisted.getId(), persisted.getName());
    }
}
