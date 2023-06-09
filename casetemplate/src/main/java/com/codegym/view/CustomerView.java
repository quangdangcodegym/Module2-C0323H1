package com.codegym.view;

import com.codegym.config.Config;
import com.codegym.model.ECustomerType;
import com.codegym.utils.FileUtils;
import com.codegym.model.Customer;
import com.codegym.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerView {
    private static final int INPUT_CUSTOMER_ADD = 1;
    private static final int INPUT_CUSTOMER_EDIT = 2;
    private Scanner scanner = new Scanner(System.in);
    private List<Customer> customers;
    private String path = "./data/customer.txt";

    public CustomerView() {
        customers = new ArrayList<>();
        /**
        customers.add(new Customer(1, "Anh Nhật", "28 Nguyễn Huệ", "234546"));
        customers.add(new Customer(2, "Thiện Nhân", "29 Hà Nội", "247575"));
        customers.add(new Customer(3, "Văn Hiếu", "30 Lê Lợi", "257836"));
        customers.add(new Customer(4, "Trọng Thắng", "28 Nguyễn Chí Thanh", "0987654321"));
         **/
        customers = FileUtils.readFile(path, Config.TYPE_CUSTOMER);
    }


    public void launcher() {
        boolean checkActionMenu;
        do {
            checkActionMenu = true;
            System.out.println("===================================================");
            System.out.println("|| Chào mừng bạn đến với Menu Quản lý Khách hàng ||");
            System.out.println("|| --------------------------------------------- ||");
            System.out.println("|| Nhấn 1: Xem toàn bộ thông tin của khách hàng  ||");
            System.out.println("|| Nhấn 2: Thêm khách hàng                       ||");
            System.out.println("|| Nhấn 3: Sửa thông tin khách hàng              ||");
            System.out.println("|| Nhấn 4: Xóa khách hàng                        ||");
            System.out.println("===================================================");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    showCustomer(customers);
                    break;
                case 2:
                    addCustomerView();
                    break;
                case 3:
                    editCustomerView();
                    break;
                case 4:
                    deleteCustomerView();
                    break;
            }
            boolean repeatMenu;
            do {
                repeatMenu = true;
                System.out.println("Ban có muốn tiếp tục hay không: ");
                System.out.println("Nhập 1. Tiếp tục");
                System.out.println("Nhập 2. Kết thúc");
                int actionMenuContinue = Integer.parseInt(scanner.nextLine());
                switch (actionMenuContinue) {
                    case 1:
                        checkActionMenu = true;
                        repeatMenu = false;
                        break;
                    case 2:
                        checkActionMenu = false;
                        repeatMenu = false;
                        break;
                    default:
                        System.out.println("Không đúng lệnh, vui lòng nhập lại:");
                }
            } while (repeatMenu);
        } while (checkActionMenu);
    }

    private void deleteCustomerView() {
        showCustomer(customers);
        System.out.println("Nhập ID của khách hàng cần xóa: ");
        long idCustomerDelete = Long.parseLong(scanner.nextLine());
        Customer customerDelete = findCustomerById(customers, idCustomerDelete);
        if (customerDelete == null) {
            System.out.println("Khách hàng này không tồn tại!");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getId() == idCustomerDelete) {
                    customers.remove(i);
                    break;
                }
            }
            showCustomer(customers);
        }
    }

    private void editCustomerView() {
        showCustomer(customers);
        System.out.println("Nhập ID của khách hàng cần sửa: ");
        long idCustomerEdit = Long.parseLong(scanner.nextLine());
        Customer customerEdit = findCustomerById(customers, idCustomerEdit);
        if (customerEdit != null) {
            inputCustomer(INPUT_CUSTOMER_EDIT, customerEdit);
        } else {
            System.out.println("Khách hàng này không tồn tại!");
        }
        showCustomer(customers);
    }

    private void addCustomerView() {
        Customer customer = new Customer();
        customer.setId(System.currentTimeMillis() % 1000);
        inputCustomer(INPUT_CUSTOMER_ADD, customer);

        customers = FileUtils.readFile(path, Config.TYPE_CUSTOMER);
        customers.add(customer);

        FileUtils.writeFile(path, customers);
        showCustomer(customers);
    }


    private Customer findCustomerById(List<Customer> customers, long idCustomerEdit) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == idCustomerEdit) {
                return customers.get(i);
            }
        }
        return null;
    }

    public void inputNameCustomer(String strACTION,int ACTION, Customer customer){
        if(ACTION == INPUT_CUSTOMER_ADD){
            do {
                System.out.printf("Nhập tên %s của khách hàng \n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerName(name)) {
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                }else{
                    customer.setName(name);
                    break;
                }
            } while (true);
        }else {
            do {
                System.out.printf("Nhập tên %s của khách hàng Enter để bỏ qua\n", strACTION);
                String name = scanner.nextLine();
                if (!ValidateUtils.isValidCustomerName(name)) {
                    if (name.equals("")) {
                        break;
                    }
                    System.out.println("Tên không hợp lệ. Tên phải bắt đầu là kí tự và từ 8-20 kí tự, không chứa số");
                }else {
                    customer.setName(name);
                    break;
                }
            } while (true);
        }
    }

    public void inputAddressCutomer(String strACTION,int ACTION, Customer customer) {
        do{
            System.out.printf("Nhập địa chỉ %s của khách hàng: Enter để bỏ qua \n", strACTION);
            String address = scanner.nextLine();
            if (!ValidateUtils.isValidCustomerAddress(address)) {
                if (address.equals("")) {
                    break;
                }
                System.out.println("Địa chỉ không hợp lệ. Phải từ 15-50 kí tư");
            }else {
                customer.setAddress(address);
                break;
            }
        }while (true);
    }
    private void inputCustomer(int ACTION, Customer customer) {
        String strACTION = ACTION == INPUT_CUSTOMER_ADD ? "" : "mới";

        inputNameCustomer(strACTION, ACTION, customer);
        inputAddressCutomer(strACTION, ACTION, customer);

        System.out.printf("Nhập số điện thoại %s của khách hàng (*): \n", strACTION);
        String telephone = scanner.nextLine();

        System.out.println("Chọn loại khách hàng: ");
        for (ECustomerType e : ECustomerType.values()) {
            if(e.equals(customer.geteCustomerType())){
                continue;
            }
            System.out.println("Nhập " + e.getId() + "." + e.getName());
        }
        int actionMenuCustomerType = Integer.parseInt(scanner.nextLine());
        customer.seteCustomerType(ECustomerType.findById(actionMenuCustomerType));




        customer.setTelephone(telephone);
    }

    private void showCustomer(List<Customer> customers) {
        System.out.printf("%-10s | %-20s | %-20s | %-10s | %-10s\n",
                "ID", "NAME", "ADDRESS", "TELEPHONE", "TYPE");
        for (int i = 0; i < customers.size(); i++) {
            Customer item = customers.get(i);
            System.out.printf("%-10s | %-20s | %-20s | %-10s | %-10s\n",
                    item.getId(), item.getName(), item.getAddress(), item.getTelephone(), item.geteCustomerType());
        }
    }

    public static void main(String[] args) {
        CustomerView customerManager = new CustomerView();
        customerManager.launcher();
    }
}
