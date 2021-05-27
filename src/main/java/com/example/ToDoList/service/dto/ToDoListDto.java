package com.example.ToDoList.service.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ToDoListDto {
    private Long id;
    @NotNull
    private String name;
}
