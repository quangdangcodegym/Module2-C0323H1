package com.codegym.view;

import com.codegym.config.Config;
import com.codegym.model.ECategory;
import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductServiceService;
import com.codegym.utils.DateUtils;
import com.codegym.utils.ValidateUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private static final int INPUT_PRODUCT_ADD = 1;
    private static final int INPUT_PRODUCT_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);

    private IProductService iProductService;
    public ProductView() {
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

        iProductService = new ProductServiceService();
        // // cho nay can refactor: ham doc file

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
                    showProducts(iProductService.getAllProducts());
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


        showProducts(iProductService.getAllProducts());
        System.out.println("Nhập ID cần xóa: ");
        long idProductDelete = Long.parseLong(scanner.nextLine());


        Product productDelete = iProductService.findProductById(idProductDelete);

        if (productDelete == null) {
            System.out.println("Sản phẩm không tồn tại:");
        }else{
            iProductService.deleteProductById(idProductDelete);
            showProducts(iProductService.getAllProducts());
        }
    }

    private void editProductView() {
        showProducts(iProductService.getAllProducts());
        System.out.println("Nhập ID cần sua: ");
        long idProductEdit = Long.parseLong(scanner.nextLine());

        Product productEdit = iProductService.findProductById(idProductEdit);

        if (productEdit != null) {
            inputEditProductInfo(productEdit);
        }else{
            System.out.println("Sản pham khong ton tai!!");
        }
        iProductService.updateProductById(idProductEdit, productEdit);
        showProducts(iProductService.getAllProducts());
    }

    private void inputEditProductInfo(Product productEdit) {
        System.out.println("Chọn trường bạn muốn sửa");
        System.out.println("Chọn 1. Sửa tên");
        System.out.println("Chọn 2. Sửa giá");
        System.out.println("Chọn 3. Sửa mô tả");
        System.out.println("Chọn 4. Sửa danh mục");
        int actionMenuField = Integer.parseInt(scanner.nextLine());
        switch (actionMenuField) {
            case 1:
                inputNameProduct(productEdit, INPUT_PRODUCT_EDIT);
                break;
            case 2:
                inputPriceProduct(productEdit, INPUT_PRODUCT_EDIT);
                break;
        }

    }

    private void addProductView() {
        Product product = new Product();
        product.setId(System.currentTimeMillis()%1000);

        inputAddProductInfo(product);
        iProductService.addProduct(product);
        showProducts(iProductService.getAllProducts());
    }

    public String getStrAction(int ACTION) {
        String strAction = "";
        switch (ACTION) {
            case INPUT_PRODUCT_ADD:
                strAction = "";
                break;
            case INPUT_PRODUCT_EDIT:
                strAction = " bạn muốn sửa";
                break;
        }
        return strAction;
    }
    public void inputNameProduct(Product product, int ACTION) {

        String strAction = getStrAction(ACTION);
        do{
            System.out.printf("Nhập tên%s: \n", strAction);
            String name = scanner.nextLine();
            if (!ValidateUtils.isValidName(name, Config.REGEX_PRODUCT)) {
                System.out.println("Tên sản phẩm không hợp lệ. Phải từ 10-50 kí tự");
            }else{
                product.setName(name);
                break;
            }
        }while (true);
    }
    private void inputPriceProduct(Product product, int ACTION) {
        String strAction = getStrAction(ACTION);
        do{
            try {
                System.out.printf("Nhập giá%s: ", strAction);
                float price = Float.parseFloat(scanner.nextLine());
                if (price < 0 || price > 10000000) {
                    System.out.println("Vui lòng nhập đúng định dạng. Phai là số, từ 0-10.000.000");
                }else{
                    product.setPrice(price);
                    break;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Vui lòng nhập đúng định dạng. Phai là số, từ 0-10.000.000");
            }
        }while (true);
    }
    private void inputAddProductInfo(Product product) {

        inputNameProduct(product, INPUT_PRODUCT_ADD);

        System.out.println("Nhập mô tả:");
        String description = scanner.nextLine();

        inputPriceProduct(product, INPUT_PRODUCT_ADD);

        product.setCreateAt(Instant.now());
        product.setDeleteAt(null);

        System.out.println("Chọn loại danh mục: ");
        for (ECategory e : ECategory.values()) {
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionMenuCustomerType = Integer.parseInt(scanner.nextLine());
        product.setCategory(ECategory.findECategory(actionMenuCustomerType));


    }



    public void showProducts(List<Product> products) {
        System.out.printf("%-10s | %-20s | %-20s | %-10s | %-20s | %-20s | %-10s\n",
                "ID", "NAME", "DESCRIPTION", "PRICE", "CREATE DATE", "DELETE DATE", "CATEGORY");
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            Instant temp = item.getDeleteAt();
            String strDeleteAt = "";
            if (temp != null) {
                strDeleteAt = DateUtils.formatInstant(item.getDeleteAt());
            }
            System.out.printf("%-10s | %-20s | %-20s | %-10s | %-20s | %-20s | %-10s\n",
                    item.getId(), item.getName(), item.getDescription(), item.getPrice(),
                    DateUtils.formatInstant(item.getCreateAt()),strDeleteAt, item.getCategory()
                    );
        }
    }

    public static void main(String[] args) {
        ProductView productManager = new ProductView();
        productManager.launcher();
    }
}
