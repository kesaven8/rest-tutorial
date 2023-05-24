package com.elacademy.rest.controller;

import com.elacademy.rest.dto.Animal;
import com.elacademy.rest.dto.Person;
import com.elacademy.rest.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
public class RestControllerExample {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/exception")
    public String helloException() {
        throw new RuntimeException("This is an exception");
    }

    @GetMapping("/customException")
    public String helloCustomException() {
        throw new CustomException("This is an Custom Exception");
    }

    @GetMapping("/hello/{name}")
    public String getUsingPathVariable(@PathVariable(name = "name") String name) {
        throw new NullPointerException();
        //        System.out.println(name);
        //        return name.toUpperCase(Locale.ROOT);
    }


    @GetMapping("/hello/param")
    public void getUsingRequestParam(@RequestParam(name = "filter", required = false) String filter, @RequestParam(name = "sortBy") String sortBy) {
        System.out.println("Filter is : " + filter);
        System.out.println("SortBy is : " + sortBy);
    }

    @GetMapping("/hello/combine/{name}")
    public void getCombiningPathVariableAndRequestParam(@PathVariable(name = "name") String name, @RequestParam(name = "filter", required = false) String filter, @RequestParam(name = "sortBy") String sortBy) {
        System.out.println("Filter is : " + filter);
        System.out.println("SortBy is : " + sortBy);
        System.out.println("Name is : " + name);
    }

    @PostMapping("/hello/create")
    public ResponseEntity createSomething(@RequestBody Person person) {
        System.out.println("age : " + person.getAge());
        System.out.println("Name : " + person.getName());
        System.out.println("Surname : " + person.getSurname());
        return ResponseEntity.status(HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
                .header("SOMETHING", "TEST").build();
    }

    @PutMapping("/hello/modify")
    public ResponseEntity modifySomething(@RequestBody Person person) {
        System.out.println("age : " + person.getAge());
        System.out.println("Name : " + person.getName());
        System.out.println("Surname : " + person.getSurname());
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/animals")
    public List<String> getAnimals() {
        var animal = new Animal("name 001 ", "sound 001");
        var animal1 = new Animal("name 002 ", "sound 002");
        var animal2 = new Animal("name 003 ", "sound 003");
        return List.of(animal, animal1, animal2)
                .stream()
                .map(Animal::getName)
                .filter(string -> string.length() > 5)
                .collect(Collectors.toList());

    }
}
