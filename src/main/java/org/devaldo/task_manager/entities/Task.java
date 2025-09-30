package org.devaldo.task_manager.entities;

import java.time.LocalDate;

import org.devaldo.task_manager.Enums.TaskStatus;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private LocalDate createdDate;
    private TaskStatus status;
    
    public Task(String title, String description, LocalDate dueDate, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.createdDate = LocalDate.now();
        this.status = status;
    }

    public LocalDate getCreatedDate(){
        return this.createdDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    
}
