package com.example.ToDoList.mapper;

import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.service.dto.ToDoListDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ToDoListMapper {
    private final TaskMapper taskMapper;

    public ToDoListDto entityToDto(ToDoList toDoList) {
        ToDoListDto toDoListDto = new ToDoListDto();
        toDoListDto.setId(toDoList.getId());
        toDoListDto.setName(toDoList.getName());
        toDoListDto.setTasks(toDoList.getTasks().stream().map(taskMapper::entityToDto).collect(Collectors.toList()));
        toDoListDto.setColor(toDoList.getColor());
        return toDoListDto;
    }
}
