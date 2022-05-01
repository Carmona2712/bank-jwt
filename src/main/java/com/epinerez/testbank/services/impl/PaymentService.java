package com.epinerez.testbank.services.impl;

import com.epinerez.testbank.models.Payment;
import com.epinerez.testbank.repositories.IPaymentDao;
import com.epinerez.testbank.services.IPaymentService;
import com.epinerez.testbank.services.IQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements IPaymentService {

    @Autowired
    private IPaymentDao paymentDao;


    @Override
    public Payment save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public List<Payment> findAllByUser(Integer userId) {
        return paymentDao.findAllByUser(userId);
    }
}
