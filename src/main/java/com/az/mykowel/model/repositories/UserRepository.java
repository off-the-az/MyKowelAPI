package com.az.mykowel.model.repositories;


import com.az.mykowel.model.modules.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer>{
    Users findByToken(String token);
    Users deleteByToken(String token);
}
