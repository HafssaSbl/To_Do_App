package com.example.Usersservice.Exception;

public class DataNotValidException extends RuntimeException{
    public DataNotValidException(String message) {
        super(message);
    }
}
