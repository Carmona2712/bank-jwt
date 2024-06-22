package com.raca.testbank.repositories;

import com.raca.testbank.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role,Integer> {
}
