package com.epinerez.testbank.services.impl;

import com.epinerez.testbank.models.Bank;
import com.epinerez.testbank.models.User;
import com.epinerez.testbank.repositories.IBankDao;
import com.epinerez.testbank.services.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BankService implements IBankService {

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
