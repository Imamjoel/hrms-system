package com.chemco.hrms.repository;

import com.chemco.hrms.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Long> {
    Users findUserByUsername(String username);

    Users findUserByEmail(String email);
}
