package ru.LProject.animal.AnimalController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.repository.UserRepo;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public ResponseEntity GetAccount() {
        try {
            return ResponseEntity.ok("Сервер работает");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PostMapping
    public ResponseEntity regestration(@RequestBody UserEntity user){
        userRepo.save(user);
        try {
            return ResponseEntity.ok("Пользователь зарегистрирован");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Регистрация не пройдена");
        }
    }
}
