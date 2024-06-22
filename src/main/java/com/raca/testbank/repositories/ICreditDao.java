package com.raca.testbank.repositories;

import com.raca.testbank.models.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICreditDao extends JpaRepository<Credit,Integer> {
}
