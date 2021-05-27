package com.example.ToDoList.mapper;

import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.service.dto.ToDoListDto;
import org.springframework.stereotype.Component;

@Component
public class ToDoListMapper {
    public ToDoListDto entityToDto(ToDoList toDoList) {
        ToDoListDto toDoListDto = new ToDoListDto();
        toDoListDto.setId(toDoList.getId());
        toDoListDto.setName(toDoList.getName());
        return toDoListDto;
    }
}
