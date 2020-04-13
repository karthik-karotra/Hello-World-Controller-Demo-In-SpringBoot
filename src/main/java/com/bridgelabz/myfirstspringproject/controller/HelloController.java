package com.bridgelabz.myfirstspringproject.controller;

import com.bridgelabz.myfirstspringproject.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(value = "param/hello")
    public String paramHello(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return "Hello " + firstName + " " + lastName;
    }

    @RequestMapping(value = "paramInPath/{name}")
    public String paramHelloInPath(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    @PostMapping("/post")
    public String sayHelloByPost(@RequestBody User user) {
        user.setFirstName("Karthik");
        user.setLastName("Karotra");
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/putHello")
    public String sayHelloByPut(@RequestBody User user) {
        User newUser = new User();
        newUser.setFirstName("Karthik");
        newUser.setLastName("Karotra");
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return "Hello " + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/putHello1")
    public ResponseEntity<User> sayHello(@RequestBody User user) {
        User newUser = new User();
        newUser.setFirstName("Karthik");
        newUser.setLastName("Karotra");
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }
}
