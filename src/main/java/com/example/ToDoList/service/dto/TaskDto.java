package com.example.ToDoList.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private Long id;
    @NotNull
    private String description;
    private boolean status;
}
