package com.example.ToDoList.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponseDto {
    private Long id;
    private String description;
    private boolean status;
}
