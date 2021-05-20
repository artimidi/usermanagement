package com.example.usermanagement.services;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.mappers.UserMapper;
import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

    @Service
    public class UserService {

        private UserRepository userRepository;
        private UserMapper userMapper;

        @Autowired
        public UserService(UserRepository userRepository, UserMapper userMapper) {
            this.userRepository = userRepository;
            this.userMapper = userMapper;
        }
        public UserDto saveUser(UserDto userDto) {
            User user = userMapper.convertToUser(userDto);
            String userId = UUID.randomUUID().toString();
            user.setId(userId);
            userRepository.save(user);
            return userMapper.convertToUserDto(user);
        }

        public UserDto getUser(String userId) {
            return userMapper.convertToUserDto(userRepository.findUserById(userId));
        }
    }
