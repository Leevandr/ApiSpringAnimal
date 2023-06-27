package ru.LProject.animal.AnimalController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.LProject.animal.Entity.UserEntity;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @GetMapping("/")
    public ResponseEntity GetAccount() {
        try {
            return ResponseEntity.ok("Сервер работает");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
