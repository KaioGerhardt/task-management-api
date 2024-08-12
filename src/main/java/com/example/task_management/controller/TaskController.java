package com.example.task_management.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @GetMapping
    public String getAllTasks() {
        return "";
    }

    @PostMapping
    public Boolean createTask(@RequestBody Task task) {
        return true;
    }

    @PutMapping("/{id}")
    public String updateTask(@PathVariable String id, @RequestBody String entity) {
        return entity;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTask(@PathVariable String id, @RequestBody String entity){
        return true;
    }

}