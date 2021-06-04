package com.example.ToDoList.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class ToDoListDto {
    private Long id;

    @NotNull
    private String name;

    private List<TaskDto> tasks;

    private String color;
}
