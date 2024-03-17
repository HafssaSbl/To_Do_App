package com.example.Usersservice.Clients;


import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "task-service")
public interface TaskRestClient {
    @GetMapping("/tasks")
    List<Task> getTasksByUserId(@RequestParam("userId") Long userId);
}
