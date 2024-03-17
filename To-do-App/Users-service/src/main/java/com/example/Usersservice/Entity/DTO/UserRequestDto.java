package com.example.Usersservice.Entity.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
@AllArgsConstructor
public class UserRequestDto {
    private Long id;
    @NotBlank(message = "firstName is mandatory")
    @Size(min = 3 , max = 20 , message = "firstName most be between 3 and 20")
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    @Size(min = 3 , max = 20 , message = "lastName most be between 3 and 20")
    private String lastName;
    @NotBlank(message = "email is mandatory")
    private String email;
    public boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    }
}
