package com.example.ToDoList.mapper;

import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.model.response.ToDoListResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ToDoListMapper {
    public ToDoListResponseDto entityToDto(ToDoList toDoList){
        ToDoListResponseDto toDoListResponseDto = new ToDoListResponseDto();
        toDoListResponseDto.setId(toDoList.getId());
        toDoListResponseDto.setName(toDoList.getName());
        return  toDoListResponseDto;
    }

}
