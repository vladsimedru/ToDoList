package com.example.ToDoList.service;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.mapper.ToDoListMapper;
import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.service.dto.ToDoListDto;
import com.example.ToDoList.repository.ToDoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    private final ToDoListMapper toDoListMapper;

    public Long addToDoList(ToDoListDto toDoListDto) {
        ToDoList toDoList = new ToDoList();
        toDoList.setName(toDoListDto.getName());
        return toDoListRepository.save(toDoList).getId();
    }

    public List<ToDoListDto> getAllToDoLists() {
        return StreamSupport.stream(toDoListRepository.findAll().spliterator(),false)
                .map(toDoListMapper::entityToDto)
                .collect(Collectors.toList());
    }

    public ToDoListDto getToDoList(Long toDoListId) throws BusinessException {
        ToDoList toDoList = toDoListRepository.findById(toDoListId).orElseThrow(() -> new BusinessException(404, "To Do List NOT Found"));
        return toDoListMapper.entityToDto(toDoList);
    }
}
