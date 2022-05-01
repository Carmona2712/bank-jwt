package com.epinerez.testbank.repositories;

import com.epinerez.testbank.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditDao extends JpaRepository<Credit,Integer> {
}
