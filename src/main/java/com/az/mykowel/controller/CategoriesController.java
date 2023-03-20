package com.az.mykowel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.az.mykowel.model.services.CategoriesService;
import com.az.mykowel.model.entity.*;

import java.util.*;

@RestController
@RequestMapping("categories")
public class CategoriesController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/get")
    public ResponseEntity<?> get(){
        try {
            return new ResponseEntity<List<Categories>>(categoriesService.listAllCategories(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
        }
    }
}
