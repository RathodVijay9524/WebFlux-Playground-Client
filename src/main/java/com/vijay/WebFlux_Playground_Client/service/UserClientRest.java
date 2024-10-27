package com.vijay.WebFlux_Playground_Client.service;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;

import java.util.List;

@HttpExchange(url = "users",accept = "application/json",contentType = "application/json")
public interface UserClientRest {

    @GetExchange
    List<UserDto> getAllUser();

    @GetExchange("/{id}")
    UserDto getUserById(@PathVariable Long id);

    @PostExchange
    UserDto createUser(@RequestBody UserDto user);

    @PutExchange("/{id}")
    UserDto updateUser(@PathVariable Long id, @RequestBody UserDto user);

    @DeleteExchange("/{id}")
    UserDto deleteUser(@PathVariable Long id);

    @PostExchange("/add")
    String createUsers(@RequestBody UserDto user);

    @DeleteExchange("/delete/{id}")
    String deleteUsers(@PathVariable Long id);
}
