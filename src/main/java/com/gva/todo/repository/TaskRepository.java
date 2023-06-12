package com.gva.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gva.todo.entity.Status;
import com.gva.todo.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findAllByStatus(Status status);

}
