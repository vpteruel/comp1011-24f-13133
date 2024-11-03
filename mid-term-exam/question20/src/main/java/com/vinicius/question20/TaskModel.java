package com.vinicius.question20;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private List<Task> tasks;

    public TaskModel() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}