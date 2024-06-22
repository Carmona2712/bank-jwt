package com.raca.testbank.services;


import com.raca.testbank.models.User;

import java.util.List;

public interface IUserService {

    public User save(User user);

    public List<User> findAll();

    public User findById(Integer id);

    public User findByUsername(String username);


}
