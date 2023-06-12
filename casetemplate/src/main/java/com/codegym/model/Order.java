package com.codegym.model;

import com.codegym.utils.DateUtils;

import java.time.Instant;
import java.util.List;

public class Order {
    private long id;
    private String fullName;
    private float total;
    private Instant createAt;
    List<OrderItem> orderItems;


    public Order(long id, String fullName, float total, Instant createAt) {
        this.id = id;
        this.fullName = fullName;
        this.total = total;
        this.createAt = createAt;
    }

    public Order(long id, String fullName, float total, Instant createAt, List<OrderItem> orderItems) {
        this.id = id;
        this.fullName = fullName;
        this.total = total;
        this.createAt = createAt;
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public void updateTotal() {
        float total = 0;
        if (this.orderItems != null) {
            for (OrderItem orderItem : orderItems) {
                total += orderItem.getQuantity() * orderItem.getPrice();
            }
        }
        this.setTotal(total);
    }

    @Override
    public String toString() {
        //5511,Ba Dat,5000000,05-06-2023
        return String.format("%s,%s,%s,%s", this.getId(), this.getFullName(),
                this.getTotal(), DateUtils.formatInstant(this.getCreateAt()));
    }
}
