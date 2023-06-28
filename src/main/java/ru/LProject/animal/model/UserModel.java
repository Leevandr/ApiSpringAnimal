package ru.LProject.animal.model;


import lombok.Getter;
import lombok.Setter;
import ru.LProject.animal.Entity.UserEntity;

@Getter
@Setter

public class UserModel {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;

    public UserModel() {
    }

    public static UserModel toModel(UserEntity entity){
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setEmail(entity.getEmail());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        return model;
    }

}

