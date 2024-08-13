package com.example.task_management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.task_management.repository.TaskRepository;
import com.example.task_management.model.Task;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();

        if(tasks.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    public ResponseEntity createTask(Task task){
        Task taskCreated = taskRepository.save(task);
        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }

    public ResponseEntity<Task> getTaskById(Long id){
        return taskRepository.findById(id)
            .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}