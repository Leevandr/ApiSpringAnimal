package ru.LProject.animal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class UserExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler()
    protected ResponseEntity<T> handleThereIsNoSuchUserException() {
        return new ResponseEntity<>(new UserExceptionHandler("There is no such user"), HttpStatus.NOT_FOUND);
    }



}
