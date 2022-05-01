package com.epinerez.testbank.services;

import com.epinerez.testbank.models.Bank;

import java.util.List;

public interface IServiceBanks{

    public List<Bank> findAll();

    public List<Bank> findAllByUser(Integer userId);

}
