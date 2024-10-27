package com.vijay.WebFlux_Playground_Client.service;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public interface RestClientUserService {

    @GetExchange("/users")
    Flux<UserDto> getAllUser();

    @GetExchange("/users/{id}")
    Mono<UserDto> getUserById(@PathVariable Long id);

    @PostExchange("/users")
    Mono<UserDto> createUser(@RequestBody UserDto user);

    @PutExchange("/users/{id}")
    Mono<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user);

    @DeleteExchange("/users/{id}")
    Mono<UserDto> deleteUser(@PathVariable Long id);

    @PostExchange("/users/add")
    Mono<String> createUsers(@RequestBody UserDto user);

    @DeleteExchange("/users/delete/{id}")
    Mono<String> deleteUsers(@PathVariable Long id);

}
