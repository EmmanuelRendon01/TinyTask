package com.tinytask.TinyTask.repository;

import com.tinytask.TinyTask.model.Task;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TaskRepository {
    List<Task> findAll();
    Task create(Task task);
    Task findById(int id);
    Boolean update(int id, Task newTask);
    Boolean delete(int id);
}
