package com.elacademy.rest.dto;

import javax.validation.constraints.Max;

public class Person {

    private String name;

    private String surname;

    @Max(value = 100)
    private Integer age;

    Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
