package com.raca.testbank.services.impl;

import com.raca.testbank.models.Payment;
import com.raca.testbank.repositories.ICreditDao;
import com.raca.testbank.repositories.IPaymentDao;
import com.raca.testbank.services.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private IPaymentDao paymentDao;
    @Autowired
    private ICreditDao creditDao;


    @Override
    public Payment save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public List<Payment> findAllByUser(Integer userId) {
        return paymentDao.findAllByUser(userId);
    }
}
