package com.gva.todo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gva.todo.entity.Task;
import com.gva.todo.service.TaskService;

import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String tasksView(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        return "tasksView";
    }

    @GetMapping("create")
    public String taskForm(@PathParam("id") Long id, Model model) {
        if(Objects.nonNull(id)){
            Task task = taskService.findById(id);
            model.addAttribute("task", task);
            return "taskForm";
        }
        model.addAttribute("task", new Task());
        return "taskForm";
    }

    @PostMapping
    public String createTask(@ModelAttribute("task") Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

}
