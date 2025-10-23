package com.tinytask.TinyTask.model;

public class Task {
    private int id;
    private String title;
    private String description;
    private String user_id;

    public Task(int id, String title, String description, String user_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user_id = user_id;
    }

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
