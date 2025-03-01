package com.example.praktika;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task updateTask(int id, Task.Status status) {
        return taskRepository.findById(id).map(task -> {
            task.setStatus(status);
            return taskRepository.save(task);
        }).orElse(null);
    }

    public Task deleteTask(int id) {
        return taskRepository.findById(id).map(task -> {
            taskRepository.delete(task);
            return task;
        }).orElse(null);
    }
}
