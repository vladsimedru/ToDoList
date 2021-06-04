package com.example.ToDoList.service;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.mapper.TaskMapper;
import com.example.ToDoList.model.Task;
import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.service.dto.TaskDto;
import com.example.ToDoList.repository.TaskRepository;
import com.example.ToDoList.repository.ToDoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskService {
    private final ToDoListRepository toDoListRepository;

    private final TaskRepository taskRepository;

    private final TaskMapper taskMapper;

    public Long addTask(Long toDoListId, TaskDto taskDto) throws BusinessException {
        ToDoList toDoList = toDoListRepository.findById(toDoListId).orElseThrow(() -> new BusinessException(404, "To Do List NOT Found"));
        Task task = new Task();
        task.setStatus(false);
        task.setDescription(taskDto.getDescription());
        task.setToDoList(toDoList);
        return taskRepository.save(task).getId();
    }

    public List<TaskDto> getTasksByToDoListId(Long id) {
        return taskRepository.findByToDoListId(id)
                .stream()
                .map(taskMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public TaskDto updateTaskStatus(Long taskId, boolean status) {
        Task task = taskRepository.getById(taskId);
        task.setStatus(status);
        Task updatedTask = taskRepository.save(task);
        return taskMapper.entityToDto(updatedTask);
    }
}
