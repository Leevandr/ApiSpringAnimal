package ru.LProject.animal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.exceptions.UserAlreadyDeleteException;
import ru.LProject.animal.exceptions.UserAlreadyExistException;
import ru.LProject.animal.exceptions.UserHaveABlankException;
import ru.LProject.animal.exceptions.UserNotFoundException;
import ru.LProject.animal.model.UserModel;
import ru.LProject.animal.repository.UserRepo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService extends RegistrationService {

    @Autowired
    private UserRepo userRepo;


    public UserEntity registration(UserEntity user) throws UserAlreadyExistException, UserHaveABlankException {

        if (userRepo.findByFirstName(user.getFirstName()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");

        }
        return userRepo.save(user);
    }

    public UserModel getOne(Integer id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(Long.valueOf(id)).get();
         if (user == null){
             throw new UserNotFoundException("Пользователь не найден");
         }
         return UserModel.toModel(user);
    }
    public String  deleteUser(Long id) throws UserAlreadyDeleteException {
        if (id == null){
            throw new UserAlreadyDeleteException("Пользователь уже удалён");
        }
        userRepo.deleteById(id);
        return "Пользователь " + id + " удалён";
    }

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
