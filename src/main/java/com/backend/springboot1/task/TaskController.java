package com.backend.springboot1.task;

import com.backend.springboot1.task.dtos.CreateTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TasksService tasksService;

    public TaskController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping("")
    ResponseEntity<List<Task>> getAllTasks() {
        var tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("")
    ResponseEntity<Task> createTask(@RequestBody CreateTaskDTO createTaskDTO) {
        var createdTask = tasksService.createTask(createTaskDTO.getName(), createTaskDTO.getDueDate());
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/{id}")
    ResponseEntity<Task> getTaskById(@PathVariable("id") Integer id) {
        var task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    /***
     *  Todo 1: implement Update Task - PUT
     *  Todo 2: implement Delete Task - DELETE
     *  Todo 3: - handle expection for IllegalArgumentException ( due date, name)
     *  Todo 4 - in error responses, also send the error message in the response body
     *  Todo 5: create a ResponseBodyDTO - only return name, dueDate, completed
     */

    @ExceptionHandler(TasksService.TaskNotFoundException.class)
    ResponseEntity<String> handleTaskNotFoundException(TasksService.TaskNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
