package com.codegym.service;

import com.codegym.config.Config;
import com.codegym.model.Order;
import com.codegym.utils.FileUtils;

import java.util.List;

public class OrderService implements IOrderService{
    private final String pathOrder = "./data/order.txt";
    private IOrderItemService iOrderItemService;
    public OrderService() {
        iOrderItemService = new OrderItemService();
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = FileUtils.readFile(pathOrder, Config.TYPE_ORDER);
        for (Order o : orders) {
            o.setOrderItems(iOrderItemService.getOrderItems(o.getId()));
        }
        return orders;
    }

    @Override
    public Order findOrder(long idOrder) {
        List<Order> orders = getAllOrders();
        for (Order order : orders) {
            if (order.getId() == idOrder) {
                return order;
            }
        }
        return null;
    }

    @Override
    public void saveOrder(Order order) {
        // Lưu thông tin vào file order
        List<Order> orders = getAllOrders();
        orders.add(order);

        // Lưu thông tin vào file orderitem
        iOrderItemService.saveOrderItems(order.getOrderItems());

        FileUtils.writeFile(pathOrder, orders);
    }
}
