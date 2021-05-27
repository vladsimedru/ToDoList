package com.example.ToDoList.repository;

import com.example.ToDoList.model.ToDoList;
import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoList,Long> {
}
