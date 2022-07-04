package com.elacademy.rest.dto;

public class Person {
    private String name;
    private String surname;
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
