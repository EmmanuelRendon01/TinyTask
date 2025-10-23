package com.tinytask.TinyTask.controller;

import com.tinytask.TinyTask.model.Task;
import com.tinytask.TinyTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/api/Task")
@CrossOrigin(origins = "http://localhost:5173")
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
    public Task createTask(@RequestBody Task task){
        task.setStatus("Pendiente");
        return taskService.create(task);
    }

    @GetMapping("/getById")
    public Task getById(@RequestBody int id){
        return taskService.findById(id);
    }

    @PutMapping("/update/{id}")
    public Task updateById(@PathVariable int id, @RequestBody Task task){
        return taskService.updateById(id, task);
    }

    @DeleteMapping("/delete/{id}")
    public Task deleteById(@PathVariable int id){
        return taskService.deleteById(id);
    }
}
