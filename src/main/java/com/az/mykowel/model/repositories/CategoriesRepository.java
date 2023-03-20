package com.az.mykowel.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.az.mykowel.model.entity.Categories;

public interface CategoriesRepository  extends JpaRepository<Categories, Long> {

}
