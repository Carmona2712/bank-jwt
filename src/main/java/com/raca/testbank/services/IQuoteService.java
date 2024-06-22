package com.raca.testbank.services;

import com.raca.testbank.models.Quote;

import java.util.List;

public interface IQuoteService {

    public Quote save(Quote quote);

    public Quote findById(Integer id);

    public List<Quote> findAllByBank(Integer bankId);

    public Quote findAllById(Integer id);


}
