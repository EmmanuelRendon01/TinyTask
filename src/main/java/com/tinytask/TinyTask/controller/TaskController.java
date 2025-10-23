package com.tinytask.TinyTask.controller;

import com.tinytask.TinyTask.model.Task;
import com.tinytask.TinyTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("/getTasks")
    public List<Task> getAllTask() {
        return taskService.findAll();
    }

    @PostMapping("/createTask")
    public Task createTask(String id, String title, String description, String user_id){
        int newId = Integer.parseInt(id);
        Task task = new Task(newId, title, description, user_id);
        return taskService.create(task);
    }

    @GetMapping("/getById")
    public Task getById(@RequestBody int id){
        return taskService.findById(id);
    }
}
