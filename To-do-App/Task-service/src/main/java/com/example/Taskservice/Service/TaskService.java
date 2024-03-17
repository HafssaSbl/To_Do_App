package com.example.Taskservice.Service;


import com.example.Taskservice.Entity.DTO.TaskRequestDto;
import com.example.Taskservice.Entity.DTO.TaskResponseDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto createTask(TaskRequestDto taskDto);
    TaskResponseDto getTaskById(Long id) throws Exception;
    TaskResponseDto updateTask(Long id, TaskRequestDto taskDto) throws Exception;
    void deleteTask(Long id) throws Exception;
}
