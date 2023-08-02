package ru.LProject.animal.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.lang.reflect.Array;
import java.time.DateTimeException;

@Entity
@Getter
@Setter
@Table(name = "animalEntity")
public class AnimalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long animalTypes; // тут нужно массив с числами в лонге
    private float weight;
    private float length;
    private float height;
    private String gender;
    private String lifeStatus;
    private DateTimeException chippingDateTime;
    private Integer chipperId;
    private Long chippingLocationId;
    private Long visitedLocations; // тут нужно массив с числами в лонге
    private DateTimeException deathDateTime; // тут нужно что бы был дата-формат я так (dd/mm/yy | ss/mm/hh)



}











