package com.vijay.WebFlux_Playground_Client.service;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final RestClient restClient;
    @Override
    public List<UserDto> getAllUser() {
        return this.restClient.get()
                .uri("/users")
                .retrieve()
                .body(new ParameterizedTypeReference<List<UserDto>>() {
                });
    }
    @Override
    public UserDto getUserById(Long id) {
        return this.restClient.get()
                .uri("/users/{id}",id)
                .retrieve()
                .body(UserDto.class);
    }
    @Override
    public UserDto createUser(UserDto user) {
        return this.restClient.post()
                .uri("/users")
                .body(user)
                .retrieve()
                .body(UserDto.class);
    }

    @Override
    public UserDto updateUser(Long id, UserDto user) {
        return this.restClient.put()
                .uri("/users/{id}",id)
                .body(user)
                .retrieve()
                .body(UserDto.class);
    }

    @Override
    public UserDto deleteUser(Long id) {
        return this.restClient.delete()
                .uri("/users/{id}", id)
                .retrieve()
                .body(UserDto.class);
    }

    @Override
    public String createUsers(UserDto user) {
        return this.restClient.post()
                .uri("/users/add")
                .body(user)
                .retrieve()
                .body(String.class);
    }

    @Override
    public String deleteUsers(Long id) {
        return this.restClient.delete()
                .uri("/users/delete/{id}", id)
                .retrieve()
                .body(String.class);
    }
}
