package com.example.praktika;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public Task createTask(Task task) {
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task updateTask(int id, Task.Status status) {
        for (Task task : tasks ) {
            if (task.getId() == id) {
                task.setStatus(status);
                return task;
            }
        }
        return null;
    }

    public Task deleteTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                tasks.remove(task);
                return task;
            }
        }
        return null;
    }
}
