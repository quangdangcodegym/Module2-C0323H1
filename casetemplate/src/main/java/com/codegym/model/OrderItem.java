package com.codegym.model;

public class OrderItem {
    private long id;

    private long idOrder;
    private long idProduct;
    private int quantity;
    private float price;

    public OrderItem(long id, long idOrder, long idProduct, int quantity) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public OrderItem(long id, long idOrder, long idProduct, int quantity, float price) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        //3,5511,5287,5,10000

        return String.format("%s,%s,%s,%s,%s", this.getId(), this.getIdOrder(), this.getIdProduct(), this.getQuantity(), this.getPrice());
    }
}
