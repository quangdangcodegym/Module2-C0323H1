package com.codegym.model;

import com.codegym.utils.DateUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;

public class Product {
    private long id;
    private String name;
    private String description;
    private float price;
    private Instant createAt;
    private Instant deleteAt;

    private ECategory category;

    public Product() {

    }

    public Instant getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Instant deleteAt) {
        this.deleteAt = deleteAt;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public Product(long id, String name, String description, float price, Instant createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
    }

    public Product(long id, String name, String description, float price, Instant createAt, Instant deleteAt, ECategory category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createAt = createAt;
        this.deleteAt = deleteAt;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        //5284,Iphone XXX,Dep lam,23000.0,05-06-2023,null,PHONE
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return String.format("%s,%s,%s,%s,%s,%s,%s\n", this.id, this.name, this.description,
                this.price, DateUtils.formatInstant(this.createAt),DateUtils.formatInstant(this.deleteAt), this.category);
    }
}
