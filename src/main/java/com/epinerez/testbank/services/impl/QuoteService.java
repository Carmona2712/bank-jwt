package com.epinerez.testbank.services.impl;

import com.epinerez.testbank.models.Quote;
import com.epinerez.testbank.repositories.IQuoteDao;
import com.epinerez.testbank.services.IQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuoteService implements IQuoteService {

    @Autowired
    private IQuoteDao quoteDao;

    @Override
    @Transactional
    public Quote save(Quote quote) {
        return quoteDao.save(quote);
    }

    @Override
    @Transactional(readOnly = true)
    public Quote findById(Integer id) {
        if(quoteDao.existsById(id)){
            return quoteDao.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Quote> findAllByBank(Integer bankId) {
        return quoteDao.findAllByBank(bankId);
    }

    @Override
    @Transactional
    public Quote findAllById(Integer id) {
        return null;
    }
}
