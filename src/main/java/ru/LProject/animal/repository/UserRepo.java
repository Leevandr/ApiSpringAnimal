package ru.LProject.animal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import ru.LProject.animal.Entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {


}
