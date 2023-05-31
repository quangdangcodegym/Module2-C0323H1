package com.codegym;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static final int INPUT_PRODUCT_ADD = 1;
    private static final int INPUT_PRODUCT_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);
    private List<Product> products;

    public ProductManager() {
        //id, String name, String description, String price, Date createAt

        try {
            products = new ArrayList<>();
            products.add(new Product(System.currentTimeMillis()%10000, "Iphone X", "Dep lam", 23000, new Date()));
            Thread.sleep(500);
            products.add(new Product(System.currentTimeMillis()%10000, "Iphone 11", "Dep lam", 23000, new Date()));
            Thread.sleep(500);
            products.add(new Product(System.currentTimeMillis()%10000, "Iphone 12", "Dep lam", 23000, new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void launcher() {
        boolean checkActionMenu;
        do{
            checkActionMenu  = true;
            System.out.println("Menu quản lý sản phẩm");
            System.out.println("Nhập 1. Xem sản phẩm");
            System.out.println("Nhập 2. Thêm sản phẩm");
            System.out.println("Nhập 3. Sua san phẩm");
            System.out.println("Nhập 4. Xóa sản phẩm");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showProducts(products);
                    break;
                case 2:
                    addProductView();
                    break;
                case 3:
                    editProductView();
                    break;
                case 4:
                    deleteProductView();
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
        }while (checkActionMenu);

    }

    private void deleteProductView() {
        showProducts(products);
        System.out.println("Nhập ID cần xóa: ");
        long idProductDelete = Long.parseLong(scanner.nextLine());
        Product productDelete = findProductById(products, idProductDelete);

        if (productDelete == null) {
            System.out.println("Sản phẩm không tồn tại:");
        }else{
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getId() == idProductDelete) {
                    products.remove(i);
                    break;
                }
            }
            showProducts(products);
        }
    }

    private void editProductView() {
        showProducts(products);
        System.out.println("Nhập ID cần sua: ");
        long idProductEdit = Long.parseLong(scanner.nextLine());
        Product productEdit = findProductById(products, idProductEdit);

        if (productEdit != null) {
            inputProduct(INPUT_PRODUCT_EDIT, productEdit);
        }else{
            System.out.println("Sản pham khong ton tai!!");
        }
        showProducts(products);
    }

    private void addProductView() {
        Product product = new Product();
        product.setId(System.currentTimeMillis()%1000);
        inputProduct(INPUT_PRODUCT_ADD, product);
        products.add(product);
        showProducts(products);
    }

    private Product findProductById(List<Product> products, long idProductEdit) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idProductEdit) {
                return products.get(i);
            }
        }
        return null;
    }

    private void inputProduct(int ACTION, Product product) {
        String strACTION = ACTION == INPUT_PRODUCT_ADD ? "" : "mới";
        System.out.printf("Nhập tên %s: \n", strACTION);
        String name = scanner.nextLine();
        System.out.printf("Nhập mô tả %s: \n", strACTION);
        String description = scanner.nextLine();
        System.out.printf("Nhập gia %s: \n", strACTION);
        float price = Float.parseFloat(scanner.nextLine());
        Date createAt = new Date();


        product.setPrice(price);
        product.setName(name);
        product.setDescription(description);
        product.setCreateAt(createAt);
    }

    private void showProducts(List<Product> products) {
        System.out.printf("%-10s | %-20s | %-20s | %-10s | %-20s\n",
                "ID", "NAME", "DESCRIPTION", "PRICE", "DATE");
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-10s | %-20s\n",
                    item.getId(), item.getName(), item.getDescription(), item.getPrice(), item.getCreateAt());
        }
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.launcher();
    }
}
