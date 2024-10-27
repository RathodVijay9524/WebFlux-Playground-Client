package com.vijay.WebFlux_Playground_Client.controller;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import com.vijay.WebFlux_Playground_Client.service.WebClientRestService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client/users")
@AllArgsConstructor
public class WebClientUserController {

    private final WebClientRestService webClientRestService;

    @RequestMapping
    public Flux<UserDto> getAllUser() {
        return webClientRestService.getAllUser();
    }
    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserDto>> getUserById(@PathVariable Long id) {
        return webClientRestService.getUserById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<UserDto>> createUser(@RequestBody UserDto user) {
        return webClientRestService.createUser(user)
                .map(ResponseEntity::ok);
    }


    @PutMapping("/{id}")
    public Mono<ResponseEntity<UserDto>> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        return webClientRestService.updateUser(id, user)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable Long id) {
        return webClientRestService.deleteUser(id)
                .thenReturn(ResponseEntity.noContent().<Void>build())
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()));
    }
    @DeleteMapping("/delete/{id}")
    public Mono<ResponseEntity<String>> deleteUsers(@PathVariable Long id) {
        return webClientRestService.deleteUsers(id)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.notFound().build()));
    }
    @PostMapping("/add")
    public Mono<ResponseEntity<String>> createUsers(@RequestBody UserDto userDto) {
        return webClientRestService.createUsers(userDto)
                .map(ResponseEntity::ok)
                .onErrorResume(e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Error creating user: " + e.getMessage())));
    }
}

/*
@PutMapping("/{id}")
public Mono<ResponseEntity<String>> updateUser(@PathVariable Long id, @RequestBody UserDto userDetails) {
    return userService.updateUser(id, userDetails)
            .map(updatedUser -> ResponseEntity.ok("User updated successfully"))
            .defaultIfEmpty(ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"));
}*/
