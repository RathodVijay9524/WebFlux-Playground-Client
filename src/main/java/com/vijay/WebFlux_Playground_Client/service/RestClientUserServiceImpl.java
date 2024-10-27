package com.vijay.WebFlux_Playground_Client.service;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class RestClientUserServiceImpl {
    private final RestClientUserService restClientUserService;
    public Flux<UserDto> getAllUser() {
        return restClientUserService.getAllUser()
                .doOnNext(result -> log.info("received: {}", result));
    }

    public Mono<UserDto> getUserById(Long id) {
        return restClientUserService.getUserById(id);
    }

    public Mono<UserDto> createUser(UserDto user) {
        return restClientUserService.createUser(user);
    }

    public Mono<UserDto> updateUser(Long id, UserDto user) {
        return restClientUserService.updateUser(id, user);
    }

    public Mono<UserDto> deleteUser(Long id) {
        return restClientUserService.deleteUser(id);
    }

    public Mono<String> createUsers(UserDto user) {
        return restClientUserService.createUsers(user);
    }

    public Mono<String> deleteUsers(Long id) {
        return restClientUserService.deleteUsers(id);
    }
}
