package com.az.mykowel.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.az.mykowel.model.entity.Contacts;
import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.ContactsService;
import com.az.mykowel.model.services.UserService;

@RestController
@RequestMapping("contacts")
public class ContactsController {
     
    @Autowired
    private ContactsService contactsService;

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        try{
            return new ResponseEntity<List<Contacts>>(contactsService.listAllNumber(), HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); 
        }
    }

    @GetMapping("/get/owner")
    public ResponseEntity<?> getByOwner(@RequestParam(value = "value", required = true, defaultValue = "") String owner){
        try{
            return new ResponseEntity<List<Contacts>>(contactsService.findNumberByOwner(owner), HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); 
        }
    }

    @GetMapping("/get/id")
    public ResponseEntity<?> getById(@RequestParam(value = "value", required = true, defaultValue = "") Long id){
        try{
            return new ResponseEntity<Optional<Contacts>>(contactsService.findById(id), HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>(null, HttpStatus.CONFLICT); 
        }
    }

    @PostMapping(value = "/add", consumes = {"*/*"})
    public ResponseEntity<?> add(@ModelAttribute Contacts contact, @RequestHeader String token) {
        try{
            Users user = userService.getUserByToken(token);
            if(user.checkPerms(user.getIs_admin())) {
                contactsService.saveNumber(contact);
                return new ResponseEntity<>("Contact added", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Permissions denied", HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters or logs", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@ModelAttribute Contacts contact, @RequestHeader Long id, @RequestHeader String token) {
        try {
            Users user = userService.getUserByToken(token);
            if(user.checkPerms(user.getIs_admin())) {
                Contacts exitContact = contactsService.findNumberById(id);
                contact.setId(exitContact.getId());
                contactsService.saveNumber(contact);
                return new ResponseEntity<>("Contact saved", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Permissions denied", HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parametrs or logs", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> delete(@RequestHeader Long id, @RequestHeader String token) {
        try{
            Users user = userService.getUserByToken(token);
            if(user.checkPerms(user.getIs_admin())) {
                contactsService.deleteNumber(id);
                return new ResponseEntity<>("Contact deleted", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Permissions denied", HttpStatus.FORBIDDEN);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters or logs", HttpStatus.CONFLICT);
        }
    }
}
