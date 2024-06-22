package com.raca.testbank.repositories;


import com.raca.testbank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserDao extends JpaRepository<User,Integer> {

    @Query("from User u where u.username = :username")
    public User findyByUsername(String username);


}
