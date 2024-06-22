package com.raca.testbank.controllers;

import com.raca.testbank.models.Payment;
import com.raca.testbank.services.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @PostMapping
    public ResponseEntity<Payment> save(Payment payment){
        Payment newPayment = paymentService.save(payment);
        return ResponseEntity.ok(newPayment);
    }






}
