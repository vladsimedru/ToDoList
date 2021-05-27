package com.example.ToDoList.model.dto;

import com.sun.istack.NotNull;

public class AddToDoListDto {
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
