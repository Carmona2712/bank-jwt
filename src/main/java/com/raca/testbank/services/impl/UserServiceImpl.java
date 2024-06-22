package com.raca.testbank.services.impl;


import com.raca.testbank.models.User;
import com.raca.testbank.repositories.IUserDao;
import com.raca.testbank.services.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user) {
        log.info("Password: {}", user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Password encoded: {}", user.getPassword());
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
