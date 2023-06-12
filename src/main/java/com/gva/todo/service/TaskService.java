package com.gva.todo.service;

import java.util.List;

import com.gva.todo.entity.Status;
import com.gva.todo.entity.Task;

public interface TaskService {

    Task findById(Long id);
    List<Task> findAll();
    List<Task> findAllByStatus(Status status);
    void deleteById(Long id);
    Task save(Task task);
}
