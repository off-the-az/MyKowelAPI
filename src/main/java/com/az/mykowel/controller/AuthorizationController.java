package com.az.mykowel.controller;

import java.security.*;
import java.util.*;
import java.io.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.EmailSenderService;
import com.az.mykowel.model.services.UserService;

@RestController
public class AuthorizationController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSenderService emailSenderService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam(value = "login", required = true, defaultValue = "") String login, @RequestParam(value = "password", required = true, defaultValue = "") String password){
        List<Users> users = new ArrayList<>();
        Users user = new Users();
        users = userService.listAllUser();
        password = md5(md5(password));
        int status = 404;
        for (Users value : users) {
            if (Objects.equals(login, value.getLogin()) && Objects.equals(password, value.getPassword())) {
                value.setToken(generateNewToken());
                userService.saveUser(value);
                user = value;
                status = 200;
            }
        }
        if(status == 200) return new ResponseEntity<Users>(user, HttpStatus.OK);
        else return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
    }

    @PostMapping("/reset-request")
    public ResponseEntity<?> sendResetRequestByEmail(@RequestParam(value = "username", required = true, defaultValue = "") String username){
        try {
            Users user = new Users();
            user = userService.getUserByUsername(username);
            System.out.println(user.getEmail());
            emailSenderService.sendMail(user.getEmail(), "Відновлення пароля доступу до аккаунту - " + username, 
            "Шановний користувач!\nВи подали запит на відновлення пароля доступу до вашого аккаунту в системі My Kowel.Задля відновлення доступу до системи перейдіть за даним посиланням та встановіть новий пароль аби увійти в систему.\n\nПосилання на відновлення паролю - http://mykowel.pp.ua:8000/password-reset?token="+user.getToken()+"\n\nЗ повагою, команда розробки C&L Studio та My Kowel DevTeam!");
            return new ResponseEntity<>("Password reset sended!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader String token){
        try{
            Users user = userService.getUserByToken(token);
            user.setToken(" ");
            return new ResponseEntity<Users>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        } 
    }

    @PostMapping(value = "/register", consumes = {"*/*"})
    public ResponseEntity<?> add(@ModelAttribute Users user) {
        try{
            List<Users> users = new ArrayList<>();
            users = userService.listAllUser();
            int status = 404;
            for (Users value : users) {
                if(!Objects.equals(value.getLogin(), user.getLogin())){
                    status = 200;
                }
                else{
                    status = 404;
                }
            }
            if(status == 200)
            {
                String password = user.getPassword();
                user.setPassword(md5(md5(password)));
                user.setIs_admin("0");
                user.setToken(generateNewToken());
                userService.saveUser(user);
                System.out.println(user.getEmail() + " " + user.getLogin() + " " + user.getName() + " " + user.getPassword() + " " + user.getPhone());
                return new ResponseEntity<Users>(user, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("User had been creating", HttpStatus.CONFLICT);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        }
    }

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();
    
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