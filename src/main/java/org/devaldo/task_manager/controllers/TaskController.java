package org.devaldo.task_manager.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import org.devaldo.task_manager.Enums.TaskStatus;
import org.devaldo.task_manager.entities.Task;
import org.devaldo.task_manager.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController("/api/v1/task")
public class TaskController {
    TaskService taskService;

    @GetMapping("/create")
    public Task createTask(
        @RequestParam Long id,
        @RequestParam String title, 
        @RequestParam String description, 
        @RequestParam LocalDate dueDate, 
        @RequestParam TaskStatus status
        ) {
        return taskService.createTask(id, title, description, dueDate, status);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }
    
    @GetMapping("/remove/{id}")
    public Task removeTask(@PathVariable Long id) {
        return taskService.removeTask(id);
    }

    @GetMapping("/complete/{id}")
    public Task getMethodName(@PathVariable Long id) {
        return taskService.completeTask(id);
    }
    
    @GetMapping("/fiter/{status}")
    public List<Task> getMethodName(@PathVariable TaskStatus status) {
        return taskService.filterTasksByStatus(status);
    }
    
}
