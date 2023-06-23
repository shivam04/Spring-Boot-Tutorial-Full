package com.backend.springboot1.task.dtos;

import lombok.Data;

@Data
public class UpdateTaskDTO {
    String dueDate;
    Boolean completed;
}
