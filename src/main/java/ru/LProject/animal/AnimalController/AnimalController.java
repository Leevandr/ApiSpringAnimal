package ru.LProject.animal.AnimalController;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animal")
public class AnimalController {


    public String str1 = "muu";
    public  String sayMu() {
        return this.str1;
    }

}
