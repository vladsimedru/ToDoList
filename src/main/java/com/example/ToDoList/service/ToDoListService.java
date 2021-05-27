package com.example.ToDoList.service;

import com.example.ToDoList.exception.BusinessException;
import com.example.ToDoList.mapper.ToDoListMapper;
import com.example.ToDoList.model.ToDoList;
import com.example.ToDoList.model.dto.AddToDoListDto;
import com.example.ToDoList.model.response.ToDoListResponseDto;
import com.example.ToDoList.repository.ToDoListRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    private final ToDoListMapper toDoListMapper;

    public Long addToDoList(AddToDoListDto addToDoListDto) {
        ToDoList toDoList = new ToDoList();
        toDoList.setName(addToDoListDto.getName());
        return toDoListRepository.save(toDoList).getId();
    }

    public List<ToDoListResponseDto> getAllToDoLists() {
        List<ToDoListResponseDto> list = new ArrayList<>();
        for (ToDoList toDoList : toDoListRepository.findAll()) {
            list.add(toDoListMapper.entityToDto(toDoList));
        }
        return list;
    }

    public ToDoListResponseDto getToDoList(Long id) throws BusinessException {
        ToDoList toDoList = toDoListRepository.findById(id).orElseThrow(() -> new BusinessException(404, "To Do List NOT Found"));
        return toDoListMapper.entityToDto(toDoList);
    }

}
