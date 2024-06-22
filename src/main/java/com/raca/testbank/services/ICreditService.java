package com.raca.testbank.services;

import com.raca.testbank.models.Credit;
import com.raca.testbank.models.Payment;

public interface ICreditService {

    public Credit applyPayment(Payment payment) throws Exception;

}
