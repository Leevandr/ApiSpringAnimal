package ru.LProject.animal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.exceptions.UserAlreadyExistException;
import ru.LProject.animal.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByFirstName(user.getFirstName()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует");
        }
         return userRepo.save(user);
    }

}
