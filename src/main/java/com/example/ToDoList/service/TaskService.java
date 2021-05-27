package com.example.ToDoList.service;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.mapper.TaskMapper;
import com.example.ToDoList.model.Task;
import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.model.dto.AddTaskDto;
import com.example.ToDoList.model.response.TaskResponseDto;
import com.example.ToDoList.repository.TaskRepository;
import com.example.ToDoList.repository.ToDoListRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class TaskService {
    private final ToDoListRepository toDoListRepository;

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public Long addTask(Long id, AddTaskDto addTaskDto) throws BusinessException {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow(()->new BusinessException(404,"To Do List NOT Found"));
        Task task = new Task();
        task.setStatus(false);
        task.setDescription(addTaskDto.getDescription());
        task.setToDoList(toDoList);
        return taskRepository.save(task).getId();
    }

    public List<TaskResponseDto> getTasksByToDoListId(Long id) {
        return taskRepository.findByToDoListId(id)
                .stream()
                .map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }
}
