package com.example.Taskservice.Entity.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDto {
    @Valid

    private Long id;

    @NotBlank(message = "title is mandatory")
    private String title;

    @NotBlank(message = "description is mandatory")
    @Size(min = 20 , max = 100 , message = "description most be between 20 and 100")
    private String description;

    @NotBlank(message = "status is mandatory")
    private String status;

    @NotBlank(message = "dueDate is mandatory")
    private Date dueDate;
    public boolean isValidDueDate() {
        Date currentDate = new Date();
        return dueDate.after(currentDate);
    }


}
