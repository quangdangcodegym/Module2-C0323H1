package com.codegym.service;

import com.codegym.config.Config;
import com.codegym.model.OrderItem;
import com.codegym.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService implements IOrderItemService{
    private final String pathOrderItem = "./data/order_item.txt";
    @Override
    public List<OrderItem> getAllOrderItems() {
        return FileUtils.readFile(pathOrderItem, Config.TYPE_ORDER_ITEM);
    }

    @Override
    public List<OrderItem> getOrderItems(long idOrder) {
        List<OrderItem> orderItems = getAllOrderItems();
        List<OrderItem> results = new ArrayList<>();

        for (OrderItem orderItem : orderItems) {
            if (orderItem.getIdOrder() == idOrder) {
                results.add(orderItem);
            }
        }
        return results;
    }

    @Override
    public void saveOrderItems(List<OrderItem> orderItemsAdd) {
        List<OrderItem> orderItems = getAllOrderItems();

        orderItems.addAll(orderItemsAdd);
        FileUtils.writeFile(pathOrderItem, orderItems);
    }
}
