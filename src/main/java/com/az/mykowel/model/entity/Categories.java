package com.az.mykowel.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Categories{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private Long id;
    private String name;
    private String cat_id;

    public Categories(){}

    public Categories(Long id, String name, String cat_id){
        this.id = id;
        this.name = name;
        this.cat_id = cat_id;
    }
}