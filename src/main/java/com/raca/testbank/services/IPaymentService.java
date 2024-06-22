package com.raca.testbank.services;

import com.raca.testbank.models.Payment;

import java.util.List;

public interface IPaymentService {

    public Payment save(Payment payment);

    public List<Payment> findAllByUser(Integer userId);


}
