package ru.LProject.animal.exceptions;

public class UserHaveABlankException extends Throwable {
    /// пробел в юзернейме
    public UserHaveABlankException(String messege) {
        super(messege);
    }
}
