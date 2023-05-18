package com.az.mykowel.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.UserService;


@Controller
public class ViewContrller {

    @Autowired
    private UserService userService;

    @GetMapping("/password-reset")
    public String resetPasswordForm(@RequestParam(name="token", required=true, defaultValue="") String token, Model model){
        model.addAttribute("token", token);
        return "resetPasswordForm";
    }

    @GetMapping("/update-pass")
    public String resetByToken(@RequestParam(value = "password", required = true, defaultValue = "") String password, @RequestParam(value = "token", required = true, defaultValue = "") String token){
        try {
            Users user = new Users();
            user = userService.getUserByToken(token);
            user.setPassword(md5(md5(password)));
            userService.saveUser(user);
            return "passwordChangedOK";
        } catch (Exception e) {
            System.out.println(e);
            return "passwordChangedCONFLICT";
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
