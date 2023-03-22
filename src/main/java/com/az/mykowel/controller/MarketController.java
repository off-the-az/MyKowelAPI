package com.az.mykowel.controller;

import com.az.mykowel.model.entity.Market;
import com.az.mykowel.model.entity.Users;
import com.az.mykowel.model.services.FileService;
import com.az.mykowel.model.services.MarketService;
import com.az.mykowel.model.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Collections;

@RestController
@RequestMapping("market")
public class MarketController {

    @Autowired
    private FileService fileStorageService;

    @Autowired
    private UserService userService;

    @Autowired
    private MarketService marketService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){
        try {
            List<Market> items = new ArrayList<>();
            items = marketService.listAllMarket();
            Collections.reverse(items);
            return new ResponseEntity<List<Market>>(items, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<NoSuchElementException>(e, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/id")
    public ResponseEntity<?> getById(@RequestParam(value = "value", required = true, defaultValue = "") Long Id){
        try {
            return new ResponseEntity<Market>(marketService.getItemById(Id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<NoSuchElementException>(e, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/category")
    public ResponseEntity<?> getByCategory(@RequestParam(value = "value", required = true, defaultValue = "") String category){
        try {
            List<Market> items = new ArrayList<>();
            items = marketService.listAllMarketByCategory(category);
            Collections.reverse(items);
            return new ResponseEntity<List<Market>>(items, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<NoSuchElementException>(e, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/get/title")
    public ResponseEntity<?> getByTitle(@RequestParam(value = "value", required = true, defaultValue = "") String title){
        try{
            List<Market> items = new ArrayList<>();
            items = marketService.listAllMarketByTitle(title);
            Collections.reverse(items);
            return new ResponseEntity<List<Market>>(items, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<NoSuchElementException>(e, HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value="/add", consumes = {"*/*"})
    public ResponseEntity<?> send(@ModelAttribute Market item, @RequestParam("file") MultipartFile file,  @RequestHeader String token){
        try{
            Users user = userService.getUserByToken(token);
            String fileName = fileStorageService.storeFile("market", String.valueOf(user.getId()), file);
            String fileDownloadUri = "http://mykowel.pp.ua:8000/downloadFile/market/" + fileName;
            item.setUser_id(user.getId());
            item.setPhoto(fileDownloadUri);
            item.setPnumber(user.getPhone());
            marketService.saveMarket(item);
            return new ResponseEntity<Market>(item, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
        }

    }

    @PutMapping("/set/sold")
    public ResponseEntity<?> getAll(@RequestParam(value = "id", required = true, defaultValue = "") Long id){
        try {
            Market item = new Market();
            item = marketService.getItemById(Id);
            item.setSold(1);
            marketService.saveMarket(item);
            return new ResponseEntity<Market>(item, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<NoSuchElementException>(e, HttpStatus.CONFLICT);
        }
    }
    
    @PutMapping(value="/update", consumes={"*/*"})
    public ResponseEntity<?> update(@ModelAttribute Market market, @RequestHeader Long id){
        try{
            Market item = marketService.getItemById(id);
            market.setId(item.getId());
            marketService.saveMarket(market);
            return new ResponseEntity<Market>(market, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
        }
    }
    
    @DeleteMapping(value="/delete", consumes={"*/*"})
    public ResponseEntity<?> delete(@RequestHeader Long id, @RequestHeader String token){
        try{
            Users user = userService.getUserByToken(token);
            if(user.checkPerms(user.getIs_admin())) {
                marketService.deleteMarket(id);
                return new ResponseEntity<>("Item deleted", HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>("Permissions denied", HttpStatus.FORBIDDEN);
            }
        }catch(Exception e){
            return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
        }
    }

}
