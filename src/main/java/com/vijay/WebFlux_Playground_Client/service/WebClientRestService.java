package com.vijay.WebFlux_Playground_Client.service;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
@Log4j2
public class WebClientRestService {

    private final WebClient webClient;

    public Flux<UserDto> getAllUser(){
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToFlux(UserDto.class)
                .doOnNext(result -> log.info("received: {}", result));
    }
    public Mono<UserDto> getUserById(Long id) {
        return webClient.get()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(UserDto.class);
    }

    public Mono<UserDto> createUser(UserDto user) {
        return webClient.post()
                .uri("/users")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(UserDto.class);
    }

    public Mono<UserDto> updateUser(Long id, UserDto user) {
        return webClient.put()
                .uri("/users/{id}", id)
                .bodyValue(user)
                .retrieve()
                .bodyToMono(UserDto.class);
    }

    public Mono<Void> deleteUser(Long id) {
        return webClient.delete()
                .uri("/users/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }


    public Mono<String> createUsers(UserDto user) {
        return webClient.post()
                .uri("/users/add")
                .bodyValue(user)
                .retrieve()
                .bodyToMono(String.class);
    }
    public Mono<String> deleteUsers(Long id) {
        return webClient.delete()
                .uri("/users/delete/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
    }
}

   /* public Mono<String> updateUsers(Long id, UserDto user) {
        return webClient.post()
                .uri("/add/users/{id}", id)
                .bodyValue(user)
                .retrieve()
                .bodyToMono(String.class);
    }*/