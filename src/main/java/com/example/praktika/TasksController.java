package com.example.praktika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class TasksController {

    @Autowired
    private TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping ("/tasks")

    public List getTasks() {
        return taskService.getTasks();
    }

    @PostMapping ("/tasks")

    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping ("/tasks/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id, @RequestBody Task.Status status) {
        Task updatedTask = taskService.updateTask(id, status);
        if (updatedTask == null) {
            return new ResponseEntity<>("Task with this ID was not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Task updated", HttpStatus.OK);
    }

    @DeleteMapping ("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        Task deletedTask = taskService.deleteTask(id);
        if (deletedTask == null) {
            return new ResponseEntity<>("Task with this ID was not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Task deleted", HttpStatus.OK);
    }
}
