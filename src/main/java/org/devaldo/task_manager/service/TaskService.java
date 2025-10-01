package org.devaldo.task_manager.service;

import java.time.LocalDate;
import java.util.List;

import org.devaldo.task_manager.Enums.TaskStatus;
import org.devaldo.task_manager.entities.Task;
import org.devaldo.task_manager.repositories.TaskRepository;

public class TaskService {
    TaskRepositoryImpl taskRepository = new TaskRepositoryImpl();

    public Task createTask(Long id, String title, String description, LocalDate dueDate, TaskStatus status){
        return taskRepository.createTask(id, title, description, dueDate, status);
    }

    public Task getTaskById(Long id){
        return taskRepository.getTaskById(id);
    }

    public List<Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    public Task removeTask(Long id){
        return taskRepository.removeTask(id);
    }

    public Task completeTask(Long id){
        return taskRepository.completeTask(id);
    }

    public List<Task> filterTasksByStatus(TaskStatus status){
        return taskRepository.filterTasksByStatus(status);
    }
}
