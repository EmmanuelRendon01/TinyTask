package com.tinytask.TinyTask.repository;

import com.tinytask.TinyTask.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskIMP implements TaskRepository{

    List<Task> db = new ArrayList<>();

    @Override
    public List<Task> findAll() {
        return db;
    }

    @Override
    public Task create(Task task) {
        task.setId(db.size()+1);
        db.add(task);
        return task;
    }


    @Override
    public Task findById(int id) {

        for (Task task : db) {
            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    @Override
    public Task update(int id, Task task) {
        for (Task existingTask  : db) {

            if (existingTask.getId() == id) {
                existingTask.setTitle(task.getTitle());
                existingTask.setDescription(task.getDescription());
                return task;
            }
        }
        return null;

    }

    @Override
    public Task delete(int id) {
        for (int i = 0; i < db.size(); i++) {
            Task currentTask = db.get(i);
            if (currentTask.getId() == id) {
                db.remove(i);
                return currentTask;
            }
        }

        return null;
    }
}
