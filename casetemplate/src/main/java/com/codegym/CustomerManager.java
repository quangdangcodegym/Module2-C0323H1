package com.codegym;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        try {
            customers = new ArrayList<>();
            //Customer(long id, String name, String phone, String address)
            customers.add(new Customer(System.currentTimeMillis() % 1000, "Quang Dang", "12345678", "28 NTP"));
            Thread.sleep(500);
            customers.add(new Customer(System.currentTimeMillis() % 1000, "Quang Dang1", "12345678", "28 NTP"));
            Thread.sleep(500);
            customers.add(new Customer(System.currentTimeMillis() % 1000, "Quang Dang2", "12345678", "28 NTP"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void laucher() {
        System.out.println("Menu quản ly khách hàng: ");
        System.out.println("Nhập 1. Xem sản phẩm");
        System.out.println("Nhập 2. Thêm sản phẩm");
        System.out.println("Nhập 3. Sua san phẩm");
        System.out.println("Nhập 4. Xóa sản phẩm");
        System.out.println("Nhập 5. Sắp xếp sản phẩm");
    }

}
