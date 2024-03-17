package com.example.Usersservice.Service;


import com.example.Usersservice.Entity.DTO.UserRequestDto;
import com.example.Usersservice.Entity.DTO.UserResponseDto;
import com.example.Usersservice.Repository.UserRepository;
import com.example.Usersservice.Utilis.MappingProfile;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class UserServiceImp implements UserService{
    private final UserRepository userRepo;
    @Override
    public List<UserResponseDto> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(MappingProfile::mapToUserDto).toList();
    }
    @Override
    public UserResponseDto createUser(UserRequestDto userDto) {
        if (!userDto.isValidEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("Invalid email address");
        }
        var user = MappingProfile.mapToUserEntity(userDto);
        return MappingProfile.mapToUserDto(userRepo.save(user));
    }
    @Override
    public Object getUserById(Long id) throws Exception {
        var user = userRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
        return new Object(){
            public Long id = user.getId();
            public String fullName = user.getLastName().toUpperCase() + ", " + user.getFirstName();
            public String email = user.getEmail();


          /*  public List<Object> tasks = Collections.singletonList(user.getTasks().stream().map(task -> new Object() {
                public Long id = task.getId();
                public String title = task.getTitle();
                public String description = task.getDescription();
                public String status = task.getStatus();
                public String dueDate = task.getDueDate().toString();
                public String createdAt = task.getCreatedAt().toString();
                public String updatedAt = task.getUpdatedAt().toString();
            }).toList());
           */
        };
    }

    @Override
    public UserResponseDto updateUser(Long id, UserRequestDto userDto) throws Exception {
        var user = userRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        return MappingProfile.mapToUserDto(userRepo.save(user));
    }
    @Override
    public void deleteUser(Long id) throws Exception {
        var user = userRepo.findById(id).orElseThrow(() -> new Exception("User not found"));
        userRepo.delete(user);
    }
}
