package com.example.Taskservice.Service;


import com.example.Taskservice.Entity.DTO.TaskRequestDto;
import com.example.Taskservice.Entity.DTO.TaskResponseDto;
import com.example.Taskservice.Exception.NotFoundException;
import com.example.Taskservice.Repository.TaskRepository;
import com.example.Taskservice.Utils.MappingProfile;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {


    private final TaskRepository taskRepo;

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return taskRepo.findAll().stream()
                .map(MappingProfile::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskResponseDto createTask(TaskRequestDto taskDto) {
        if (!taskDto.isValidDueDate()) {
            throw new IllegalArgumentException("Due date must be in the future");
        }
        var task = MappingProfile.mapToEntity(taskDto);
        return MappingProfile.mapToDto(taskRepo.save(task));
    }

    @Override
    public TaskResponseDto getTaskById(Long id) throws NotFoundException {
        var task = taskRepo.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        return MappingProfile.mapToDto(task);
    }

    @Override
    public TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws NotFoundException {
        var task = taskRepo.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        task.setDueDate(task.getDueDate());
        return MappingProfile.mapToDto(taskRepo.save(task));
    }

    @Override
    public void deleteTask(Long id) throws NotFoundException {
        var task = taskRepo.findById(id).orElseThrow(() -> new NotFoundException("Task not found"));
        taskRepo.delete(task);
    }
}
