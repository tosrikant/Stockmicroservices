package com.sritest.dbservice.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyException extends RuntimeException {

    private String message;

    public MyException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return  message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
