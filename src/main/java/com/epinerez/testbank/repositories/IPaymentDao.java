package com.epinerez.testbank.repositories;

import com.epinerez.testbank.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPaymentDao extends JpaRepository<Payment,Integer> {

    @Query("from Payment p where p.user.id = :userId")
    public List<Payment> findAllByUser(Integer userId);


}
