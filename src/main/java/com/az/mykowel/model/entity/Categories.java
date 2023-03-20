package com.az.mykowel.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Categories{

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCat_Id() {
        return cat_id;
    }

    public void setCat_Id(String cat_id) {
        this.cat_id = cat_id;
    }

    private Long Id;
    private String name;
    private String cat_id;

    public  Categories(Long id, String name, String cat_id){
        this.Id = id;
        this.name = name;
        this.cat_id = cat_id;
    }
}