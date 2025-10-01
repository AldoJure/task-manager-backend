package org.devaldo.task_manager.repositories;

import java.util.List;
import java.util.Optional;

import org.devaldo.task_manager.entities.Task;

public interface TaskRepository {

    Task save(Task task);                 
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void remove(Long id);
}
