package com.example.ToDoList.mapper;

import com.example.ToDoList.model.Task;
import com.example.ToDoList.model.response.TaskResponseDto;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskResponseDto entityToDto(Task task) {
        TaskResponseDto taskResponseDto = new TaskResponseDto();
        taskResponseDto.setId(task.getId());
        taskResponseDto.setStatus(task.isStatus());
        taskResponseDto.setDescription(task.getDescription());
        return taskResponseDto;
    }
}
