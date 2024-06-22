package com.raca.testbank.services;

import com.raca.testbank.models.Bank;

import java.util.List;

public interface IServiceBanks{

    public List<Bank> findAll();

    public List<Bank> findAllByUser(Integer userId);

}
