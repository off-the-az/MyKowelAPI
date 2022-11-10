package com.az.mykowel.controller;

import java.security.*;
import java.util.*;
import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.UserService;

@RestController
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(value = "login", required = true, defaultValue = "") String login, @RequestParam(value = "password", required = true, defaultValue = "") String password){
        List<Users> users = new ArrayList<>();
        users = userService.listAllUser();
        Users user = new Users();
        password = md5(md5(password));
        int status = 404;
        for (Users value : users) {
            if (Objects.equals(login, value.getLogin()) && Objects.equals(password, value.getPassword())) {
                user = value;
                user.setToken(generateNewToken()); //  !!! need to refactor for future tokenisation system !!!
                userService.saveUser(user);
                status = 200;
            }
        }
        if(status == 200) return new ResponseEntity<Users>(user, HttpStatus.OK); // need to show full information in personal account MK-users
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

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
    
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    

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