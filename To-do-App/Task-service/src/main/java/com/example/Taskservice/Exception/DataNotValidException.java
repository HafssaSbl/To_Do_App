package com.example.Taskservice.Exception;

public class DataNotValidException extends RuntimeException{
    public DataNotValidException(String message) {
        super(message);
    }
}
