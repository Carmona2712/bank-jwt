package com.epinerez.testbank.controllers;

import com.epinerez.testbank.models.Bank;
import com.epinerez.testbank.models.User;
import com.epinerez.testbank.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}/banks")
    public List<Bank> findAllBanksByUser(@PathVariable(name = "id") Integer id){
        User user = userService.findById(id);
        return user.getBanks();
    }

}
