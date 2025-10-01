package org.devaldo.task_manager.repositories;

import java.util.List;

import org.devaldo.task_manager.Enums.TaskStatus;
import org.devaldo.task_manager.entities.Task;

public interface TaskRepository {

    Task createTask();

    Task getTaskById(Long id);

    List<Task> getAllTasks();

    Task removeTask(Long id);

    Task completeTask(Long id);

    List<Task> filterTasksByStatus(TaskStatus status);
}
