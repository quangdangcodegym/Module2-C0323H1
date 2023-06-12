package com.codegym.utils;

import com.codegym.config.Config;
import com.codegym.model.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileUtils {
    public static <T> List<T> readFile(String path, String type) {
        List<T> datas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //5284,Iphone X,Dep lam,23000.0,Mon Jun 05 16:55:35 ICT 2023
                String [] items = line.split(",");
                switch (type) {
                    case Config.TYPE_CUSTOMER:
                        parseTypeCustomer(items, datas);
                        break;
                    case Config.TYPE_PRODUCT:
                        parserTypeProduct(items, datas);
                        break;
                    case Config.TYPE_USER:
                        parseTypeUser(items, datas);
                        break;
                    case Config.TYPE_ORDER:
                        parseTypeOrder(items, datas);
                        break;
                    case Config.TYPE_ORDER_ITEM:
                        parseTypeOrderItem(items, datas);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    private static <T> void parseTypeOrderItem(String[] items, List<T> datas) {
        //1,5510,5284,1
        OrderItem orderItem = new OrderItem(Long.parseLong(items[0]), Long.parseLong(items[1]),
                Long.parseLong(items[2]), Integer.parseInt(items[3]), Float.parseFloat(items[4]));
        datas.add((T) orderItem);
    }

    private static <T> void parseTypeOrder(String[] items, List<T> datas) {
//        5511,Ba Dat,5000000,05-06-2023
        long idOrder = Long.parseLong(items[0]);
        float price = Float.parseFloat(items[2]);
        Instant createAt = DateUtils.parseStrInstant(items[3]);
        Order order = new Order(idOrder, items[1], price, createAt);

        datas.add((T) order);
    }

    private static <T> void parseTypeUser(String[] items, List<T> datas) {
        long id = Long.parseLong(items[0]);
        String name = items[1];
        String addressN = items[2];
        Egender egender = Egender.valueOf(items[3]);
        ERole erole = ERole.valueOf(items[4]);
        LocalDate d = null;
        if (!items[5].equals("null")) {
            d = DateUtils.parseStrLocalDate(items[5]);
        }
        User e = new User(id, name, addressN, egender, erole, d);
        datas.add((T) e);
    }

    private static <T> void parserTypeProduct(String[] items, List<T> datas) throws ParseException {
        // line: 5284,Iphone XXX,Dep lam,23000.0,2023-06-05 05:30:25,null,PHONE

        long idProduct = Long.parseLong(items[0]);
        float price = Float.parseFloat(items[3]);

        //long id, String name, String description, float price, Instant createAt, Instant deleteAt, ECategory category) {
        Instant deleteAt = null;
        if (!items[5].equalsIgnoreCase("null")) {
            deleteAt = DateUtils.parseStrInstant(items[5]);
        }
        ECategory category = ECategory.findECategory(items[6]);
        Product p = new Product(idProduct, items[1], items[2], price, DateUtils.parseStrInstant(items[4]),
                deleteAt, category);
        datas.add((T) p);
    }

    private static <T> void parseTypeCustomer(String[] items, List<T> datas) {
        long idCustomer = Long.parseLong(items[0]);
        String fullName = items[1];
        String address = items[2];
        String phone = items[3];
        ECustomerType eCustomerType = ECustomerType.find(items[4]);
        //id, String name, String address, String telephone
        Customer customer = new Customer(idCustomer, fullName, address, phone);
        customer.seteCustomerType(eCustomerType);
        datas.add((T) customer);
    }

    public static <T> void writeFile(String path, List<T> datas) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (T p : datas) {
                bufferedWriter.write(p.toString() + "\n");
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
