package com.epinerez.testbank.controllers;

import com.epinerez.testbank.models.Bank;
import com.epinerez.testbank.services.impl.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @GetMapping
    public List<Bank> findAll(){
        return bankService.findAll();
    }


}
