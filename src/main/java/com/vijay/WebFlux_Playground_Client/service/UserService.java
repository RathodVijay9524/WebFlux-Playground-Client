package com.vijay.WebFlux_Playground_Client.service;

import com.vijay.WebFlux_Playground_Client.model.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUser();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto user);
    UserDto updateUser(Long id, UserDto user);
    UserDto deleteUser(Long id);
    String createUsers(UserDto user);
    String deleteUsers(Long id);
}
