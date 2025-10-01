package org.devaldo.task_manager.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.devaldo.task_manager.Enums.TaskStatus;
import org.devaldo.task_manager.entities.Task;
import org.devaldo.task_manager.repositories.TaskRepository;

public class TaskRepositoryImpl implements TaskRepository{

    @Override
    public Task createTask(Long id, String title, String description, LocalDate dueDate, TaskStatus status) {
        Task newTask = new Task(id, title, description, dueDate, status);
        return newTask;
    }

    @Override
    public Task getTaskById(Long id) {
        Task newTask = new Task(id, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING);
        return newTask;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> taskList = List.of(
        new Task(001L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING),
        new Task(002L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING),
        new Task(003L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING));

        return taskList;
        
    }

    @Override
    public Task removeTask(Long id) {
        Task newTask = new Task(id, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING);
        return newTask;
    }

    @Override
    public Task completeTask(Long id) {
        Task newTask = new Task(id, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.DONE);
        return newTask;
    }

    @Override
    public List<Task> filterTasksByStatus(TaskStatus status) {
        List<Task> taskListPending = List.of(
        new Task(001L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING),
        new Task(002L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING),
        new Task(003L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.PENDING));

        List<Task> taskListInProgress = List.of(
        new Task(001L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.IN_PROGRESS),
        new Task(002L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.IN_PROGRESS),
        new Task(003L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.IN_PROGRESS));

        List<Task> taskListDone = List.of(
        new Task(001L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.DONE),
        new Task(002L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.DONE),
        new Task(003L, "random title", "random description", LocalDate.of(2025, 10, 5), TaskStatus.DONE));

        if (status == TaskStatus.PENDING) {
            return taskListPending;
        }else if (status == TaskStatus.IN_PROGRESS) {
            return taskListInProgress;
        }else if (status == TaskStatus.DONE){
            return taskListDone;
        }
        List<Task> emptyList = new ArrayList<>();
        return emptyList;
    }

}
