package com.epinerez.testbank.services;

import com.epinerez.testbank.models.Payment;

import java.util.List;

public interface IPaymentService {

    public Payment save(Payment payment);

    public List<Payment> findAllByUser(Integer userId);


}
