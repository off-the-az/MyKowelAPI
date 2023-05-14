package com.az.mykowel.model.entity;

import javax.persistence.*;

@Entity
public class Market {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String pnumber;
    private Long owner;
    private String photo;
    private short checked;
    private short sold;

    public Market(Long id, String title, String description, double price, String category, String pnumber, Long owner, short checked, String photo, short sold){
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.pnumber = pnumber;
        this.owner = owner;
        this.checked = checked;
        this.photo = photo;
        this.sold = sold;
    }

    public Market() {

    }

    public void setSold(short sold){ this.sold = sold; }

    public short getSold() { return this.sold; }

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

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
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
