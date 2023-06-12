package com.codegym.service;

import com.codegym.model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> getAllOrders();
    Order findOrder(long idOrder);
    void saveOrder(Order order);
}
