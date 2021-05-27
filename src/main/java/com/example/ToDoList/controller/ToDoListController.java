package com.example.ToDoList.controller;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.model.dto.AddTaskDto;
import com.example.ToDoList.model.dto.AddToDoListDto;
import com.example.ToDoList.model.response.TaskResponseDto;
import com.example.ToDoList.model.response.ToDoListResponseDto;
import com.example.ToDoList.service.TaskService;
import com.example.ToDoList.service.ToDoListService;
import com.example.ToDoList.utils.RequestUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to-do-lists")
@AllArgsConstructor
public class ToDoListController {

    private final ToDoListService toDoListService;

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Long> addToDoList(@RequestBody AddToDoListDto addToDoListDto) {
        return ResponseEntity.created(RequestUtils.getLocation(toDoListService.addToDoList(addToDoListDto))).build();
    }

    @GetMapping
    public ResponseEntity<List<ToDoListResponseDto>> getAllToDoLists() {
        return ResponseEntity.ok(toDoListService.getAllToDoLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoListResponseDto> getToDoList(@PathVariable Long id) throws BusinessException {
        return ResponseEntity.ok(toDoListService.getToDoList(id));
    }

    @PostMapping("/{id}/task")
    public ResponseEntity<Long> addTask(@PathVariable Long id, @RequestBody AddTaskDto addTaskDto) throws BusinessException {
        return ResponseEntity.created(RequestUtils.getLocation(taskService.addTask(id, addTaskDto))).build();
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasksByToDoListId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTasksByToDoListId(id));
    }
}
