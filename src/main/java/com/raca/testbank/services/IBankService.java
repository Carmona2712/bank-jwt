package com.raca.testbank.services;

import com.raca.testbank.models.Bank;
import com.raca.testbank.models.User;

import java.util.List;

public interface IBankService {

    public List<Bank> findAll();

    public List<Bank> findAllByUser(User user);

}
