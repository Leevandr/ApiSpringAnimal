package ru.LProject.animal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.LProject.animal.CheckUser.CheckUser;
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
    private CheckUser validation = new CheckUser();


    public UserEntity registration(UserEntity user) throws UserAlreadyExistException, UserHaveABlankException {

        if (userRepo.findByFirstName(user.getFirstName()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");

        }
        validation.ValidateAll(user);
        return userRepo.save(user);
    }

    public UserModel getOne(Integer id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(Long.valueOf(id)).get();
        if (user == null) {
            throw new UserNotFoundException("Пользователь не найден");
        }
        return UserModel.toModel(user);
    }

    public String deleteUser(Long id) throws UserAlreadyDeleteException {
        if (id == null) {
            throw new UserAlreadyDeleteException("Пользователь уже удалён");
        }
        userRepo.deleteById(id);
        return "Пользователь " + id + " удалён";
    }


}
