package com.raca.testbank.repositories;

import com.raca.testbank.models.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBankDao extends JpaRepository<Bank,Integer> {


    @Query("From Bank b where :userId member of b.users")
    public List<Bank> findAllByUsers(Integer userId);
}
