package com.az.mykowel.model.entity;

import javax.persistence.*;

@Entity
public class Market {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private Long user_id;
    private String photo;
    private short checked;

    public Market(Long id, String title, String description, double price, String category, Long user_id, String photo, short checked){
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.user_id = user_id;
        this.photo = photo;
        this.checked = checked;
    }

    public Market() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public short getChecked() {
        return checked;
    }

    public void setChecked(short checked) {
        this.checked = checked;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
}
