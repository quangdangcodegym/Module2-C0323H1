package com.codegym;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
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
        /**
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
         **/

        products = new ArrayList<>();
        // // cho nay can refactor: ham doc file
        try {
            FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0323H1\\casetemplate\\data\\product.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //5284,Iphone X,Dep lam,23000.0,Mon Jun 05 16:55:35 ICT 2023
                String[] items = line.split(",");
                long idProduct = Long.parseLong(items[0]);
                float price = Float.parseFloat(items[3]);
                // cho nay can refactor
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date =  simpleDateFormat.parse(items[4]);

                Product p = new Product(idProduct, items[1], items[2], price, date);
                products.add(p);
            }
        } catch (Exception e) {
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
        List<Product> productList = new ArrayList<>();
        // // cho nay can refactor: ham doc file
        try {
            FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0323H1\\casetemplate\\data\\product.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //5284,Iphone X,Dep lam,23000.0,Mon Jun 05 16:55:35 ICT 2023
                String[] items = line.split(",");
                long idProduct = Long.parseLong(items[0]);
                float price = Float.parseFloat(items[3]);
                // cho nay can refactor
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date =  simpleDateFormat.parse(items[4]);

                Product p = new Product(idProduct, items[1], items[2], price, date);
                productList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        showProducts(productList);
        System.out.println("Nhập ID cần xóa: ");
        long idProductDelete = Long.parseLong(scanner.nextLine());


        Product productDelete = findProductById(productList, idProductDelete);

        if (productDelete == null) {
            System.out.println("Sản phẩm không tồn tại:");
        }else{
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getId() == idProductDelete) {
                    productList.remove(i);
                    break;
                }
            }
            try {
                FileWriter fileWriter = new FileWriter("D:\\CODEGYM\\CODEGYM\\Module2\\C0323H1\\casetemplate\\data\\product.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (Product p : productList) {
                    bufferedWriter.write(p.toString());
                }
                bufferedWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            showProducts(productList);
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

        List<Product> productList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("D:\\CODEGYM\\CODEGYM\\Module2\\C0323H1\\casetemplate\\data\\product.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //5284,Iphone X,Dep lam,23000.0,Mon Jun 05 16:55:35 ICT 2023
                String[] items = line.split(",");
                long idProduct = Long.parseLong(items[0]);
                float price = Float.parseFloat(items[3]);
                // cho nay can refactor
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date date =  simpleDateFormat.parse(items[4]);

                Product p = new Product(idProduct, items[1], items[2], price, date);
                productList.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        productList.add(product);


        try {
            FileWriter fileWriter = new FileWriter("D:\\CODEGYM\\CODEGYM\\Module2\\C0323H1\\casetemplate\\data\\product.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p : productList) {
                bufferedWriter.write(p.toString());
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        showProducts(productList);
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
