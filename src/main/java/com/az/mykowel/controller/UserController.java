package com.az.mykowel.controller;

import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{token}/{check_adm}")
    public List<Users> get(@PathVariable String token, @PathVariable char check_adm) {
        Users user;
        List<Users> users = new ArrayList<>();
        user = userService.getUserByToken(token);
        char is_admin = user.getIs_admin();
        if(is_admin != '0' && check_adm != '0'){
            users = userService.listAllUser();
            return users;
        }else{
            users.add(user);
            return users;
        }
    }
    @PostMapping(value = "", consumes = {"*/*"})
    public ResponseEntity<?> add(@ModelAttribute Users user) {
        try{
            List<Users> users = new ArrayList<>();
            users = userService.listAllUser();
            for(int i = 0; i < users.size(); i++){
                if (Objects.equals(user.getLogin(), users.get(i).getLogin()) && Objects.equals(user.getPassword(), users.get(i).getPassword())){
                    userService.saveUser(user);
                    user.setIs_admin('0');
                    return new ResponseEntity<>(user, HttpStatus.OK);
                }
            }
            return null;
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        }
    }
    @PutMapping("/{token}")
    public ResponseEntity<?> update(@ModelAttribute Users user, @PathVariable String token) {
        try {
            Users existUser = userService.getUserByToken(token);
            user.setId(existUser.getId());
            userService.saveUser(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User not found. Pls, check parameters", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{token}")
    public void delete(@PathVariable String token) {
        userService.deleteUser(token);
    }

   
}
