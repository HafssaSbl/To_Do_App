package com.example.Taskservice.Utils;


import com.example.Taskservice.Entity.DTO.TaskRequestDto;
import com.example.Taskservice.Entity.DTO.TaskResponseDto;
import com.example.Taskservice.Entity.Task;
import org.modelmapper.ModelMapper;

public class MappingProfile {
    private static final ModelMapper modelMapper = new ModelMapper();
    public static Task mapToEntity(TaskRequestDto taskDto) {
        return modelMapper.map(taskDto, Task.class);
    }

    public static TaskResponseDto mapToDto(Task task) {
        return modelMapper.map(task, TaskResponseDto.class);
    }


    /*static {
        Converter<User, UserResponseDto> userToUserResponseDtoConverter = new Converter<User, UserResponseDto>() {
            public UserResponseDto convert(MappingContext<User, UserResponseDto> context) {
                User source = context.getSource();
                UserResponseDto destination = new UserResponseDto();
                destination.setId(source.getId());
                destination.setEmail(source.getEmail());
                destination.setFullName(source.getFirstName() + " " + source.getLastName());
                return destination;
            }
        };
        modelMapper.addConverter(userToUserResponseDtoConverter);
    }*/
}
