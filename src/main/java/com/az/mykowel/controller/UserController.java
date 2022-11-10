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

    @GetMapping("/{token}")
    public List<Users> get(@PathVariable String token) {
        Users user;
        List<Users> users = new ArrayList<>();
        user = userService.getUserByToken(token);
        String is_admin = user.getIs_admin();
        if(is_admin != "0"){
            users = userService.listAllUser();
            return users;
        }else{
            users.add(user);
            return users;
        }
    }
    @PostMapping(value = "/add", consumes = {"*/*"})
    public ResponseEntity<?> add(@ModelAttribute Users user) {
        try{
            List<Users> users = new ArrayList<>();
            users = userService.listAllUser();
            String password = user.getPassword();
            user.setPassword(md5(md5(password)));
            user.setIs_admin("0");
            user.setToken(generateNewToken());
            userService.saveUser(user);
            return new ResponseEntity<Users>(user, HttpStatus.OK);
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

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
    
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

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
}
