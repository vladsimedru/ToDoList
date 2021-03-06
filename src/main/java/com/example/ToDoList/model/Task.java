package com.example.ToDoList.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private boolean status;

    @ManyToOne(fetch = FetchType.LAZY)
    private ToDoList toDoList;
}
