package com.az.mykowel.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.UserService;

@RestController
public class AuthorizationController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(value = "login", required = true, defaultValue = "") String login, @RequestParam(value = "password", required = true, defaultValue = "") String password){
        List<Users> users = new ArrayList<>();
        users = userService.listAllUser();
        Users user = new Users();
        int status = 404;
        for (Users value : users) {
            System.out.println(value.getLogin() + " ? " + login);
            if (Objects.equals(login, value.getLogin()) && Objects.equals(password, value.getPassword())) {
                user = value;
                String token = "qwertyuiop";
                user.setToken(token);
                userService.saveUser(user);
                status = 200;
            }
        }
        if(status == 200) return new ResponseEntity<Users>(user, HttpStatus.OK);
        else return new ResponseEntity<>("error", HttpStatus.CONFLICT);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestParam(value = "login", required = true, defaultValue = "") String login, @RequestParam(value = "password", required = true, defaultValue = "") String password){
        List<Users> users = new ArrayList<>();
        users = userService.listAllUser();
        Users user = new Users();
        int status = 404;
        for (Users value : users) {
            System.out.println(value.getLogin() + " ? " + login);
            if (Objects.equals(login, value.getLogin()) && Objects.equals(password, value.getPassword())) {
                user = value;
                String token = "-";
                user.setToken(token);
                userService.saveUser(user);
                status = 200;
            }
        }
        if(status == 200) return new ResponseEntity<Users>(user, HttpStatus.OK);
        else return new ResponseEntity<>("error", HttpStatus.CONFLICT);
    }
}