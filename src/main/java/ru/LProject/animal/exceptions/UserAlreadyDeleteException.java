package ru.LProject.animal.exceptions;

public class UserAlreadyDeleteException extends Throwable {
    public UserAlreadyDeleteException (String message){
        super(message);
    }
}
