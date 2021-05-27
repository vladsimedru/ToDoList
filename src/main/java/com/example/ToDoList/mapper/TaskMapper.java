package com.example.ToDoList.mapper;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.service.dto.TaskDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDto entityToDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setStatus(task.isStatus());
        taskDto.setDescription(task.getDescription());
        return taskDto;
    }
}
