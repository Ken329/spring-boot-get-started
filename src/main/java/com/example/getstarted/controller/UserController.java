package com.example.getstarted.controller;

import com.example.getstarted.data.User;
import com.example.getstarted.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/users")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @PostMapping(path="/users")
    public User createUser(@RequestBody User user){
        System.out.println(user);
        return userService.createUser(user);
    }

//    @PutMapping(path="/users/{id}")
//    public User updateUser(@RequestBody User user, @PathVariable(name = "id")String id){
//        user.setId(id);
//        userService.updateUser(user);
//        return user;
//    }

    @DeleteMapping(path="/users/{id}")
    public String deleteUserById(@PathVariable String id){
        return userService.deleteUserById(id);
    }
}