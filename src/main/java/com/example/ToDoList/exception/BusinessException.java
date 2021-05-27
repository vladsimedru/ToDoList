package com.example.ToDoList.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessException extends Exception{
    public Integer status;

    public BusinessException(Integer status, String message) {
        super(message);
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}