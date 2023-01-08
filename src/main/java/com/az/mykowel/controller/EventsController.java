package com.az.mykowel.controller;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.az.mykowel.model.entity.Events;
import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.EventsService;
import com.az.mykowel.model.services.UserService;

@RestController
@RequestMapping("events")
public class EventsController {
    
    @Autowired
    private EventsService eventsService;

    @Autowired
    private UserService userService;


    @GetMapping("/get")
    public ResponseEntity<?> get(){
        try{
            return new ResponseEntity<List<Events>>(eventsService.listAll(), HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND); 
        }
    }

    @PostMapping(value = "/add", consumes = {"*/*"})
    public ResponseEntity<?> add(@ModelAttribute Events event, @RequestHeader String token){
        try{
            Users user = userService.getUserByToken(token);
            if(user.checkPerms(user.getIs_admin())) {
                eventsService.save(event);
                return new ResponseEntity<>("Event added", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Permissions denied", HttpStatus.FORBIDDEN);
            }
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND); 
        }
    }

    @DeleteMapping(value = "/delete/{Id}")
    public ResponseEntity<?> delete(@PathVariable Long Id, @RequestHeader String token){
        try{
            Users user = userService.getUserByToken(token);
            if(user.checkPerms(user.getIs_admin())) {
                eventsService.delete(Id);
                return new ResponseEntity<>("Event deleted", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Permissions denied", HttpStatus.FORBIDDEN);
            }
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND); 
        }
    }
}
