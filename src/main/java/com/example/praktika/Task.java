package com.example.praktika;

import java.time.LocalDateTime;

public class Task {
    public enum Status {
        Done,
        Not_Done
    }
    private static int idCounter = 0;
    private final int id;
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private String dueDate;
    private Status status;

    public Task(){
        this.creationDate = LocalDateTime.now();
        this.id = ++idCounter;
        this.status = Status.Not_Done;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setDueDate(int days) {
        this.dueDate = creationDate.plusDays(days).toString();
    }

    public String getDueDate() {
        return dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
