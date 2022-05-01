package com.epinerez.testbank.services;

import com.epinerez.testbank.models.Quote;

import java.util.List;

public interface IQuoteService {

    public Quote save(Quote quote);

    public Quote findById(Integer id);

    public List<Quote> findAllByBank(Integer bankId);

    public Quote findAllById(Integer id);


}
