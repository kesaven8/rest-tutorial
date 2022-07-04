package com.elacademy.rest.controller;

import com.elacademy.rest.dto.Person;
import com.elacademy.rest.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@org.springframework.web.bind.annotation.RestController
public class RestController {

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
        System.out.println(name);
        return name.toUpperCase(Locale.ROOT);
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
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/hello/modify")
    public ResponseEntity modifySomething(@RequestBody Person person) {
        System.out.println("age : " + person.getAge());
        System.out.println("Name : " + person.getName());
        System.out.println("Surname : " + person.getSurname());
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
