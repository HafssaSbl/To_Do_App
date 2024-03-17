package com.example.Taskservice.Clients;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient(name = "users-service")

public interface UserRestClient {
    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);

}
