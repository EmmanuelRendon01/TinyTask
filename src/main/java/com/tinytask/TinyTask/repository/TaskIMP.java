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
    public Boolean update(int id, Task newTask) {
        boolean find = false;
        for (Task task : db) {

            if (task.getId() == id) {
                task = newTask;
                find = true;
            }
        }

        return find;
    }

    @Override
    public Boolean delete(int id) {
        boolean find = false;
        for (int i = 0; i < db.size(); i++) {
            if (i == id) {
                db.remove(i);
                find = true;
            }
        }

        return find;
    }
}
