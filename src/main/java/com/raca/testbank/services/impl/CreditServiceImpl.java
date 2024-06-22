package com.raca.testbank.services.impl;

import com.raca.testbank.models.Credit;
import com.raca.testbank.models.Payment;
import com.raca.testbank.repositories.ICreditDao;
import com.raca.testbank.services.ICreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditServiceImpl  implements ICreditService {

    @Autowired
    private ICreditDao creditDao;

    @Override
    public Credit applyPayment(Payment payment) throws Exception {
        Credit creditDb = creditDao.findById(payment.getCredit().getId()).get();
        if(creditDb != null){
            creditDb.setBalance(creditDb.getBalance() - payment.getValue());
            return creditDao.save(creditDb);
        }
        if(creditDb == null){
            throw new Exception("Credit not found");
        }
        return null;
    }
}
