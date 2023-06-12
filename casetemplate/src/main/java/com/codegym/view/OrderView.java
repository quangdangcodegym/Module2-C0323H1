package com.codegym.view;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Product;
import com.codegym.service.IOrderService;
import com.codegym.service.IProductService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductServiceService;
import com.codegym.utils.DateUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    private Scanner scanner = new Scanner(System.in);
    private IOrderService iOrderService;
    private IProductService iProductService;


    public OrderView() {
        iOrderService = new OrderService();
        iProductService = new ProductServiceService();
    }

    public void launcher() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("Menu quản lý hóa đơn");
            System.out.println("Nhập 1. Xem danh sách hóa đơn");
            System.out.println("Nhập 2. Xem chi tiết hóa đơn");
            System.out.println("Nhập 3. Đặt hàng");
            System.out.println("Nhập 4. Cập nhật trạng thái");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showOrders(iOrderService.getAllOrders());
                    break;
                case 2:
                    showOrderDetail();
                    break;
                case 3:
                    orderProduct();
                    break;

            }
            System.out.println("Ban có muốn tiếp tục hay không: ");
            System.out.println("Nhập 1. Tiếp tục");
            System.out.println("Nhập 2. Quay lai");
            int actionMenuContinue = Integer.parseInt(scanner.nextLine());
            switch (actionMenuContinue) {
                case 1:
                    checkActionMenu = true;
                    break;
                case 2:
                    checkActionMenu = false;
                    break;
                default:
                    // Về xử lý defaul coi nak
            }
        } while (checkActionMenu);

    }

    private void orderProduct() {
        ProductView productView = new ProductView();
        productView.showProducts(iProductService.getAllProducts());
        Order order = new Order();
        order.setId(System.currentTimeMillis() % 1000);

        boolean repeatMenu = true;
        do {
            System.out.println("Nhập mã sản pham cần đặt: ");
            long idProduct = Long.parseLong(scanner.nextLine());
            Product p = iProductService.findProductById(idProduct);
            if (p == null) {
                System.out.println("Sản phẩm không tồn tại. Vui lòng nhập lại");
                continue;
            }
            boolean checkExists = checkIdProductExists(idProduct, order);

            if (checkExists) {
                // sản phẩm đã tồn tại trong hóa đơn
                System.out.println("Nhập số lượng can sua: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                updateProductInOrder(p, quantity, order);
            } else {

                System.out.println("Nhập số lượng: ");
                int quantity = Integer.parseInt(scanner.nextLine());
                addProductToOrder(p, quantity, order);
            }
            repeatMenu = true;
            System.out.println("Ban có muốn tiếp tục thêm sản phẩm vào hóa đơn hay không: ");
            System.out.println("Nhập 1. Tiếp tục");
            System.out.println("Nhập 2. Không");

            int actionMenuContinue = Integer.parseInt(scanner.nextLine());
            switch (actionMenuContinue) {
                case 1:
                    repeatMenu = true;
                    break;
                case 2:
                    repeatMenu = false;
                    break;
                default:
                    System.out.println("Không đúng lệnh, vui lòng nhập lại:");
            }
        } while (repeatMenu);

        order.updateTotal();
        System.out.println("Nhập thông tin khách hàng: ");
        String fullName = scanner.nextLine();
        order.setFullName(fullName);
        order.setCreateAt(Instant.now());
        iOrderService.saveOrder(order);

    }

    private void updateProductInOrder(Product product, int quantity, Order order) {
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getIdProduct() == product.getId()) {
                orderItem.setQuantity(quantity);
            }
        }
    }

    private void addProductToOrder(Product product, int quantity, Order order) {
        if (order.getOrderItems() == null) {
            List<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(new OrderItem(System.currentTimeMillis() % 1000, order.getId(), product.getId(), quantity, product.getPrice()));

            order.setOrderItems(orderItems);
        } else {
            OrderItem orderItem = new OrderItem(System.currentTimeMillis() % 1000, order.getId(), product.getId(), quantity, product.getPrice());
            order.getOrderItems().add(orderItem);
        }
    }

    private boolean checkIdProductExists(long idProduct, Order order) {
        if (order.getOrderItems() == null) {
            return false;
        } else {
            for (OrderItem orderItem : order.getOrderItems()) {
                if (orderItem.getIdProduct() == idProduct) {
                    return true;
                }
            }
        }
        return false;
    }

    private void showOrderDetail() {
        showOrders(iOrderService.getAllOrders());
        System.out.println("Nhập mã hóa đơn: ");
        long idOrder = Long.parseLong(scanner.nextLine());

        Order order = iOrderService.findOrder(idOrder);
        if (order == null) {
            System.out.println("Không tìm thấy hóa đơn nào!!");
        } else {
            System.out.printf("ID: %-30s           | Total: %s\n", order.getId(), order.getTotal());
            System.out.printf("FullName: %-30s           | Create at: %s\n", order.getFullName(), DateUtils.formatInstant(order.getCreateAt()));
            for (int i = 0; i < order.getOrderItems().size(); i++) {
                OrderItem item = order.getOrderItems().get(i);
                Product product = iProductService.findProductById(item.getIdProduct());
                System.out.printf("%-30s | %-5s | %-20s\n", product.getName(), item.getQuantity(), product.getPrice() * item.getQuantity());
            }

        }
    }

    private void showOrders(List<Order> allOrders) {
        System.out.printf("%-10s | %-20s | %-20s | %-20s \n",
                "ID", "FULLNAME", "TOTAL", "CREATE AT");
        for (int i = 0; i < allOrders.size(); i++) {
            Order item = allOrders.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-20s \n",
                    item.getId(), item.getFullName(), item.getTotal(), DateUtils.formatInstant(item.getCreateAt()));
        }
    }

    public static void main(String[] args) {
        OrderView orderView = new OrderView();
        orderView.launcher();
    }
}
