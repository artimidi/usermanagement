package com.example.usermanagement.controllers;

import com.example.usermanagement.dto.UserDto;
import com.example.usermanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public UserDto createUser(@RequestBody UserDto userDto)
    {
        return userService.saveUser(userDto);
    }


    @RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
    public UserDto getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

}
