package com.aledev.departamentservice.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DepartmentCodeAlreadyException extends RuntimeException{

    private String message;
        public DepartmentCodeAlreadyException(String message){
            super(message);
        }
    }

