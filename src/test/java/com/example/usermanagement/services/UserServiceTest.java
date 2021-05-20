package com.example.usermanagement.services;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.mappers.UserMapper;
import com.example.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Test
    void saveUser_happyPath() {
        UserRepository userRepository = mock(UserRepository.class);
        UserService userService = new UserService(userRepository, new UserMapper());

        UserDto userDto = new UserDto();
        userDto.setEmail("test@test.com");
        userDto.setFirstName("Dimitra");

        UserDto saveUserDto = userService.saveUser(userDto);

        assertNotNull(saveUserDto.getId());
        assertEquals("test@test.com", saveUserDto.getEmail());

    }

    @Test
    void getUser() {
    }
}