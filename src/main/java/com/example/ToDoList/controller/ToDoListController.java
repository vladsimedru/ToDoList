package com.example.ToDoList.controller;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.service.dto.TaskDto;
import com.example.ToDoList.service.dto.ToDoListDto;
import com.example.ToDoList.service.TaskService;
import com.example.ToDoList.service.ToDoListService;
import com.example.ToDoList.utils.RequestUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/to-do-lists")
@AllArgsConstructor
public class ToDoListController {

    private final ToDoListService toDoListService;

    private final TaskService taskService;

    /**
     * Add a ToDoList object
     *
     * @param toDoListDto
     * @return 201 created
     */
    @PostMapping
    public ResponseEntity<Long> addToDoList(@RequestBody ToDoListDto toDoListDto) {
        return ResponseEntity.created(RequestUtils.getLocation(toDoListService.addToDoList(toDoListDto))).build();
    }

    /**
     * get all ToDoLists
     *
     * @return A list of ToDoListDto
     */
    @GetMapping
    public ResponseEntity<List<ToDoListDto>> getAllToDoLists() {
        return ResponseEntity.ok(toDoListService.getAllToDoLists());
    }

    /**
     * get a list by ToDoListId
     *
     * @param id
     * @return a list of ToDoListDto
     * @throws BusinessException
     */
    @GetMapping("/{id}")
    public ResponseEntity<ToDoListDto> getToDoList(@PathVariable Long id) throws BusinessException {
        return ResponseEntity.ok(toDoListService.getToDoList(id));
    }

    /**
     * Add a task to a ToDoList
     *
     * @param id
     * @param taskDto
     * @return 201 created
     * @throws BusinessException
     */
    @PostMapping("/{id}/task")
    public ResponseEntity<Long> addTask(@PathVariable Long id, @RequestBody TaskDto taskDto) throws BusinessException {
        return ResponseEntity.created(RequestUtils.getLocation(taskService.addTask(id, taskDto))).build();
    }

    /**
     * get tasks by ToDoListId
     *
     * @param id
     * @return a list of TaskDto
     */
    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskDto>> getTasksByToDoListId(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.getTasksByToDoListId(id));
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<TaskDto> updateTaskStatus(@PathVariable Long id, @RequestBody TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTaskStatus(id, taskDto.isStatus()));
    }

    @DeleteMapping("/{id}")
    public void deleteToDoList(@PathVariable Long id) throws BusinessException {
        toDoListService.deleteToDoListById(id);
    }
}
