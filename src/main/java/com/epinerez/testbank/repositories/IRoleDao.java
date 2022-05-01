package com.epinerez.testbank.repositories;

import com.epinerez.testbank.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role,Integer> {
}
