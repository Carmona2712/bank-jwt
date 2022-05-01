package com.epinerez.testbank.services.impl;


import com.epinerez.testbank.models.User;
import com.epinerez.testbank.repositories.IUserDao;
import com.epinerez.testbank.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id).get();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findyByUsername(username);
    }
}
