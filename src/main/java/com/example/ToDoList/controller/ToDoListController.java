package com.example.ToDoList.controller;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.model.dto.AddToDoListDto;
import com.example.ToDoList.model.response.AddToDoListResponseDto;
import com.example.ToDoList.model.response.ToDoListResponseDto;
import com.example.ToDoList.service.ToDoListService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/to-do-lists")
@AllArgsConstructor
public class ToDoListController {

    private final ToDoListService toDoListService;

    @PostMapping
    public ResponseEntity<Long> addToDoList(@RequestBody AddToDoListDto addToDoListDto){
        return ResponseEntity.ok(toDoListService.addToDoList(addToDoListDto));
    }

    @GetMapping
    public ResponseEntity<List<ToDoListResponseDto>> getAllToDoLists(){
        return ResponseEntity.ok(toDoListService.getAllToDoLists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoListResponseDto> getToDoList(@PathVariable Long id) throws BusinessException {
        return ResponseEntity.ok(toDoListService.getToDoList(id));
    }
}
