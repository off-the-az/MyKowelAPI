package com.az.mykowel.controller.dev;

import com.az.mykowel.model.modules.Users;
import com.az.mykowel.model.services.UserService;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

@RestController
@RequestMapping("dev/user")
public class DevUserController {
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
            System.out.println(users);
            return users;
        }else{
            users.add(user);
            return users;
        }
    }
    @PostMapping(value = "", consumes = {"*/*"})
    public ResponseEntity<?> add(@ModelAttribute Users user) throws NoSuchAlgorithmException {
        try{
            List<Users> users = new ArrayList<>();
            users = userService.listAllUser();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(user.getPassword().getBytes());
            byte[] digest = md.digest();
            String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
            System.out.println(myHash);
            user.setPassword(myHash);
            for(int i = 0; i < users.size(); i++){
                if (Objects.equals(user.getLogin(), users.get(i).getLogin()) && Objects.equals(user.getPassword(), users.get(i).getPassword())){
                    userService.saveUser(user);
                    return new ResponseEntity<Users>(user, HttpStatus.OK);
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
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{token}")
    public void delete(@PathVariable String token) {
        userService.deleteUser(token);
    }

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
