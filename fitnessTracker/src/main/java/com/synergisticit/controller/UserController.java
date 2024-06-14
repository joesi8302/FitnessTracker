package com.synergisticit.controller;

import com.synergisticit.model.User;
import com.synergisticit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController(value = "user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/say")
    public String sayHello() {
        return "Hello Employee Management Application - Capstone Project";
    }


    @PostMapping("/saveUser")
    public ResponseEntity<User> savesTheUser(@RequestBody User user) {


        return new ResponseEntity<User>(userService.saveUser(user),HttpStatus.ACCEPTED);

    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId){

        return new ResponseEntity<User>(userService.findById(userId),HttpStatus.FOUND);

    }

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<User>> findAll() {

        return new ResponseEntity<List<User>>(userService.findAll(), HttpStatus.FOUND);
    }


    @PostMapping("/updateUser")
    public ResponseEntity<User> updatesTheUser(@RequestBody User user) {

        User retrievedUser = userService.findById(user.getId());

        return new ResponseEntity<User>(userService.updateUser(retrievedUser), HttpStatus.ACCEPTED) ;
    }

    @PostMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deletesTheUser(@PathVariable long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<String>("User with ID: " + userId + " has been deleted", HttpStatus.ACCEPTED);
    }

}
