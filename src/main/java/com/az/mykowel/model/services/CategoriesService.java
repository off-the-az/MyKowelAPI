package com.az.mykowel.model.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.az.mykowel.model.entity.Categories;
import com.az.mykowel.model.repositories.*;

@Service
@Transactional
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public List<Categories> listAllCategories(){
        return categoriesRepository.findAll();
    }

    public Categories findCategoryById(Long Id){
        return categoriesRepository.getById(Id);
    }

    public Optional<Categories> findById(Long Id){
        return categoriesRepository.findById(Id);
    }
}
