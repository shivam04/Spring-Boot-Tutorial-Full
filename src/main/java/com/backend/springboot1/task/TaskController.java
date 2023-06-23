package com.backend.springboot1.task;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    List<Task> taskList = new ArrayList<>();
    private int nextTaskId = 1;

    @GetMapping("")
    public List<Task> getAllTasks() {
        return taskList;
    }

    @PostMapping("")
    public Task createTask(@RequestBody Task task) {
        task.setId(nextTaskId++);
        taskList.add(task);
        return task;
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable("id") Integer id) {
        return taskList.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
