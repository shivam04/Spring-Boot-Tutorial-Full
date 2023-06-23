package com.backend.springboot1.task;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TasksService {
    List<Task> taskList = new ArrayList<>();
    private int nextTaskId = 0;

    public List<Task> getAllTasks() {
        return taskList;
    }

    public Task getTaskById(Integer id) {
        for (Task task : taskList) {
            if (task.getId().equals(id)) {
                return task;
            }
        }

        throw new TaskNotFoundException(id);
    }

    public Task createTask(String name, Date dueDate) {
        Task task = new Task(nextTaskId++, name, dueDate, false);
        taskList.add(task);
        return task;
    }

    public Task updateTask(Integer id, Date dueDate, Boolean completed) {
        Task task = getTaskById(id);
        if (dueDate != null) {
            task.setDueDate(dueDate);
        }

        if (completed != null) {
            task.setCompleted(completed);
        }

        return task;
    }

    public void deleteTask(Integer id) {
        Task task = getTaskById(id);
        taskList.remove(task);
    }

    public static class TaskNotFoundException extends IllegalStateException {
        public TaskNotFoundException(Integer id) {
            super("Task with id" + id + "not found");
        }
    }
}
