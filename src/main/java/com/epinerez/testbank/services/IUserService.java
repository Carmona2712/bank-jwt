package com.epinerez.testbank.services;


import com.epinerez.testbank.models.User;

import java.util.List;

public interface IUserService {

    public User save(User user);

    public List<User> findAll();

    public User findById(Integer id);

    public User findByUsername(String username);


}
