package ru.LProject.animal.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.repository.UserRepo;


@Service
public class RegistrationService {

    @Autowired
    private UserRepo userRepo;


    public String UpdRegistration(UserEntity user) {
        String UpdReg = String.valueOf(userRepo.findByFirstName(user.getFirstName()));
        return UpdReg;

    }

}
