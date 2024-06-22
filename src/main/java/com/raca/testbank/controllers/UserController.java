package com.raca.testbank.controllers;

import com.raca.testbank.models.Bank;
import com.raca.testbank.models.User;
import com.raca.testbank.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User newUser = userService.save(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}/banks")
    public List<Bank> findAllBanksByUser(@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);
        return user.getBanks();
    }

}
