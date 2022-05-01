package com.epinerez.testbank.services;

import com.epinerez.testbank.models.Bank;
import com.epinerez.testbank.models.User;

import java.util.List;

public interface IBankService {

    public List<Bank> findAll();

    public List<Bank> findAllByUser(User user);

}
