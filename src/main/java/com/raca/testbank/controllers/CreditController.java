package com.raca.testbank.controllers;

import com.raca.testbank.models.Credit;
import com.raca.testbank.models.Payment;
import com.raca.testbank.services.ICreditService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/credit")
@Log4j2
public class CreditController {

    @Autowired
    private ICreditService creditService;


    @PostMapping
    public ResponseEntity<Credit> applyPayment(@RequestBody Payment payment){
        try {
            Credit credit = creditService.applyPayment(payment);
            return ResponseEntity.ok(credit);
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        }

    }

}
