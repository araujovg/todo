package com.gva.todo.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gva.todo.entity.Status;
import com.gva.todo.entity.Task;
import com.gva.todo.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow( () -> new ObjectNotFoundException("Tareja não encontrada", id));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findAllByStatus(Status status) {
        return taskRepository.findAllByStatus(status);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

}
