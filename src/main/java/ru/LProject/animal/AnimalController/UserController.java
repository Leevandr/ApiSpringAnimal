package ru.LProject.animal.AnimalController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.exceptions.UserAlreadyExistException;
import ru.LProject.animal.exceptions.UserNotFoundException;
import ru.LProject.animal.repository.UserRepo;
import ru.LProject.animal.services.UserService;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity Status(){
        try {
            return ResponseEntity.ok("work");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("No work!");
        }
    }




    @GetMapping("/get")
    public ResponseEntity GetAccount(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        }catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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
