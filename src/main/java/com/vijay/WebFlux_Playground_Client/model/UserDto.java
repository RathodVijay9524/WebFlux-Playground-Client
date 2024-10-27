package com.vijay.WebFlux_Playground_Client.model;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String role;
    private String gender;
    private String mobileNumber;
}
