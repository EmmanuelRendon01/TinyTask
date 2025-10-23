package com.tinytask.TinyTask.service;

import com.tinytask.TinyTask.model.Task;
import com.tinytask.TinyTask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    public Task create(Task task){
        return taskRepository.create(task);
    }

    public Task findById(int id){
        return taskRepository.findById(id);
    }

}
