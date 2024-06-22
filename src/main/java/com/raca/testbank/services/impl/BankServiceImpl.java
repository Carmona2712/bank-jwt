package com.raca.testbank.services.impl;

import com.raca.testbank.models.Bank;
import com.raca.testbank.models.User;
import com.raca.testbank.repositories.IBankDao;
import com.raca.testbank.services.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    private IBankDao bankDao;

    @Override
    @Transactional(readOnly = true)
    public List<Bank> findAll() {
        return bankDao.findAll();
    }

    @Override
    public List<Bank> findAllByUser(User user) {
        return null;
    }
}
