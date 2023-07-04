package ru.LProject.animal.CheckUser;

import org.springframework.stereotype.Service;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.exceptions.UserAlreadyExistException;
import ru.LProject.animal.model.UserModel;
import ru.LProject.animal.repository.UserRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class CheckUser {
    public void ValidateAll(UserEntity user, UserEntity email) throws UserAlreadyExistException {

        if (user.getPassword() == null || user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null) {
            throw new UserAlreadyExistException("400");
        }
        if (user.getPassword().contains(" ") || user.getFirstName().contains(" ") || user.getLastName().contains(" ") || user.getEmail().contains(" ")) {
            throw new UserAlreadyExistException("400");
        }
        checkMail(email);

    }
        public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        public static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        public static boolean emailValidator(UserEntity user)
        {
            String email = user.getEmail();
            if (email == null) {
                return false;
            }

            Matcher matcher = EMAIL_PATTERN.matcher(email);
            return matcher.matches();
        }

        public static void checkMail( UserEntity email) throws UserAlreadyExistException {
            // Проверка адреса электронной почты
            if (emailValidator(email)) {
                throw new UserAlreadyExistException("404");
            }

        }
    }




