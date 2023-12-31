package ru.LProject.animal.AnimalController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.LProject.animal.CheckUser.CheckUser;
import ru.LProject.animal.Entity.UserEntity;
import ru.LProject.animal.exceptions.UserAlreadyDeleteException;
import ru.LProject.animal.exceptions.UserAlreadyExistException;
import ru.LProject.animal.exceptions.UserHaveABlankException;
import ru.LProject.animal.exceptions.UserNotFoundException;
import ru.LProject.animal.repository.UserRepo;
import ru.LProject.animal.services.UserService;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity getStatus() {
        try {
            return ResponseEntity.ok("work");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("No work!");
        }
    }

    @GetMapping("/get")
    public ResponseEntity getAccount(@RequestParam Integer id) {
        try {
            return ResponseEntity.ok(userService.getOne(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody UserEntity user) {
        try {
            userService.registration(user);
            return ResponseEntity.ok("Пользователь зарегистрирован");
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        } catch (UserHaveABlankException e) {
            return ResponseEntity.badRequest().body("Регистрация не пройдена");
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (UserAlreadyDeleteException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
