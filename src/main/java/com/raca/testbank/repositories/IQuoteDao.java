package com.raca.testbank.repositories;

import com.raca.testbank.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface IQuoteDao extends JpaRepository<Quote,Integer> {

    @Query("from Quote q where q.credit.id = :creditId")
    public List<Quote> findAllByBank(Integer creditId);


}
