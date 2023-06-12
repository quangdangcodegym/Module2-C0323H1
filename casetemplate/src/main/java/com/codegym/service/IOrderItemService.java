package com.codegym.service;

import com.codegym.model.OrderItem;

import java.util.List;

public interface IOrderItemService {
    List<OrderItem> getAllOrderItems();
    List<OrderItem> getOrderItems(long idOrder);

    void saveOrderItems(List<OrderItem> orderItems);
}
