package com.example.Usersservice.Entity.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private Long id;
    private String fullName;
    private String email;
}