package com.icodeap.apirest.controller;

import com.icodeap.apirest.model.User;
import com.icodeap.apirest.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    /*PostMapping, GetMapping y DeleteMapping sirve para que los métodos puedan ser expuestos en una api-rest
    Es decir, los siguientes métodos van a ser los endpoints de mi api-rest*/


    //RequestBody significa que mi app va a recibir datos en formato JSON y serán convertidos a formato Java
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public User searchUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }


}
