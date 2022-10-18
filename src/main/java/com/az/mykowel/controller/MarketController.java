package com.az.mykowel.controller;

import com.az.mykowel.model.entity.Market;
import com.az.mykowel.model.services.FileService;
import com.az.mykowel.model.services.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("market")
public class MarketController {

    @Autowired
    private FileService fileStorageService;

    @Autowired
    private MarketService marketService;

    @GetMapping("/get")
    public List<Market> get(@RequestParam(value = "category", required = true, defaultValue = "") String category){
        List<Market> items = new ArrayList<>();
        if (Objects.equals(category, "")){
            items = marketService.listAllMarket();
        }else{
            items = marketService.listAllMarketByCategory(category);
        }
        return items;
    }

    @PostMapping(value="/add", consumes = {"*/*"})
    public ResponseEntity<?> send(@ModelAttribute Market market, @RequestParam("file") MultipartFile file){
        try{
            Market item = new Market();
            item = market;
            String fileName = fileStorageService.storeFile("market", String.valueOf(market.getUser_id()), file);
            String fileDownloadUri = "https://mykovel.pp.ua:1935/downloadFile/market/" + fileName;
            item.setPhoto(fileDownloadUri);
            marketService.saveMarket(item);
            return new ResponseEntity<>("Item added", HttpStatus.OK);

        }catch (NoSuchElementException e) {
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        }

    }
    
    @PutMapping(value="/update/{id}", consumes={"*/*"})
    public ResponseEntity<?> update(@ModelAttribute Market market, @PathVariable Long id){
        try{
            Market item = marketService.getItemById(id);
            market.setId(item.getId());
            marketService.saveMarket(market);
            return new ResponseEntity<>("Item updated", HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        }
    }
    
    @DeleteMapping(value="/delete/{id}", consumes={"*/*"})
    public ResponseEntity<?> delete(@PathVariable Long id){
        try{
            marketService.deleteMarket(id);
            return new ResponseEntity<>("Item deleted", HttpStatus.OK);
        }catch(NoSuchElementException e){
            return new ResponseEntity<>("Error on sending. Pls, check parameters", HttpStatus.CONFLICT);
        }
    }

}
