package com.az.mykowel.model.services;


import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<Users> listAllUser() {
        return userRepository.findAll();
    }

    public void saveUser(Users user) {
        userRepository.save(user);
    }

    public Users getUserByToken(String token) {
        return userRepository.findByToken(token);
    }

    public Users getUserByUsername(String username) {
        return userRepository.findByLogin(username);
    }

    public void deleteUser(String token) {
        userRepository.deleteByToken(token);
    }
}
