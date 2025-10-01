package org.devaldo.task_manager.repositories;

import org.devaldo.task_manager.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryTaskRepository implements TaskRepository {

    // "Tabla" principal: id -> Task
    private final Map<Long, Task> table = new ConcurrentHashMap<>();
    // Autoincrement simple
    private final AtomicLong sequence = new AtomicLong(0);

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            long newId = sequence.incrementAndGet();
            task.setId(newId);
            table.put(newId, copy(task));
            return copy(task);
        } else {
            // update si existe; si no existe, lo tratamos como upsert simple
            table.put(task.getId(), copy(task));
            return copy(task);
        }
    }

    @Override
    public Optional<Task> findById(Long id) {
        Task t = table.get(id);
        return Optional.ofNullable(copy(t));
    }

    @Override
    public List<Task> findAll() {
        List<Task> list = new ArrayList<>();
        for (Task t : table.values()) {
            list.add(copy(t));
        }
        return list;
    }

    @Override
    public void remove(Long id) {
        table.remove(id);
    }

    // Evito exponer referencias internas (simula aislamiento de la DB)
    private Task copy(Task t) {
        if (t == null) return null;
        return new Task(t.getId(), t.getTitle(), t.getDescription(), t.isDone());
        // Nota: si tuvieses listas u objetos anidados, aquí duplicarías también.
    }
}