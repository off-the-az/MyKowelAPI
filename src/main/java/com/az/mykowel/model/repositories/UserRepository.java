package com.az.mykowel.model.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.az.mykowel.model.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
    Users findByToken(String token);
    void deleteByToken(String token);
    Users findByLogin(String login);
}
