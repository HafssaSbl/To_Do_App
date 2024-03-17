package com.example.Usersservice.Service;


import com.example.Usersservice.Entity.DTO.UserRequestDto;
import com.example.Usersservice.Entity.DTO.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
    UserResponseDto createUser(UserRequestDto taskDto);
    Object getUserById(Long id) throws Exception;
    UserResponseDto updateUser(Long id, UserRequestDto taskDto) throws Exception;
    void deleteUser(Long id) throws Exception;
}
