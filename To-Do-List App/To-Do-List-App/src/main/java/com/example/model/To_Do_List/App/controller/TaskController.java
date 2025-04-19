package com.example.model.To_Do_List.App.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.model.To_Do_List.App.model.Task;
import com.example.model.To_Do_List.App.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping("/getall")
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PostMapping("/create")
    public String createTask(@RequestBody Task task) {
        service.addTask(task);
        return "Task added!";
    }

    @PutMapping("/update")
    public String updateTask(@RequestBody Task task) {
        service.updateTask(task);
        return "Task updated!";
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable int id) {
        service.deleteTask(id);
        return "Task deleted!";
    }
}
