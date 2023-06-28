package ru.LProject.animal.AnimalController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.exceptions.UserAlreadyExistException;
import ru.LProject.animal.repository.UserRepo;
import ru.LProject.animal.services.UserService;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/get")
    public ResponseEntity GetAccount() {
        try {
            return ResponseEntity.ok("Сервер работает");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @PostMapping("/registration")
    public ResponseEntity regestration(@RequestBody UserEntity user){
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь зарегистрирован");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Регистрация не пройдена");
        }
    }
}
