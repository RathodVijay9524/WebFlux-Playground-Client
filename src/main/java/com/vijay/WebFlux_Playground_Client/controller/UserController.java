package com.vijay.WebFlux_Playground_Client.controller;

import com.vijay.WebFlux_Playground_Client.model.UserDto;
import com.vijay.WebFlux_Playground_Client.service.UserClientRest;
import com.vijay.WebFlux_Playground_Client.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        UserDto createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        UserDto updatedUser = userService.updateUser(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        UserDto userDto = userService.deleteUser(id);
        return ResponseEntity.ok(userDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
        String message = userService.deleteUsers(id);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/add")
    public ResponseEntity<String> createUsers(@RequestBody UserDto user) {
        String message = userService.createUsers(user);
        return ResponseEntity.ok(message);
    }
}
