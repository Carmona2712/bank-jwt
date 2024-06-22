package com.raca.testbank.controllers;

import com.raca.testbank.models.Bank;
import com.raca.testbank.services.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankServiceImpl bankService;

    @GetMapping
    public List<Bank> findAll(){
        return bankService.findAll();
    }


}
