package com.example.model.To_Do_List.App.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.To_Do_List.App.model.Task;
import com.example.model.To_Do_List.App.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public void addTask(Task task) {
        repository.save(task);
    }

    public void updateTask(Task task) {
        repository.update(task);
    }

    public void deleteTask(int id) {
        repository.delete(id);
    }
}
