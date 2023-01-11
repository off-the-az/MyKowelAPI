package com.az.mykowel.controller;

import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.security.*;
import java.io.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public List<Users> get(@RequestHeader String token, @RequestHeader String admin) {
        Users user;
        List<Users> users = new ArrayList<>();
        user = userService.getUserByToken(token);
        String is_admin = user.getIs_admin();
        if(user.checkPerms(is_admin) && (Objects.equals(admin, "1"))){
            users = userService.listAllUser();
            return users;
        }else{
            users.add(user);
            return users;
        }
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute Users user, @RequestHeader String token) {
        try {
            Users existUser = userService.getUserByToken(token);
            user.setId(existUser.getId());
            userService.saveUser(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User not found. Pls, check parameters", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestHeader String token) {
        try {
            userService.deleteUser(token);
            return new ResponseEntity<>("User deleted", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("User not found. Pls, check parameters", HttpStatus.NOT_FOUND);
        }
    }
    
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
    
    public static String md5(String text){
        try {
            byte[] bytesOfMessage = text.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] theMD5digest = md.digest(bytesOfMessage);
            return base64Encoder.encodeToString(theMD5digest);
        } catch(NoSuchAlgorithmException e  ) {
            e.printStackTrace();
            return null;
        }
        catch(UnsupportedEncodingException e) {
            e.printStackTrace(); 
            return null;
        }
    }
}
