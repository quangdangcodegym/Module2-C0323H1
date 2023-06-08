package com.codegym.utils;

import com.codegym.config.Config;
import com.codegym.model.Customer;
import com.codegym.model.ECustomerType;
import com.codegym.model.Product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
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
                        long idCustomer = Long.parseLong(items[0]);
                        String fullName = items[1];
                        String address = items[2];
                        String phone = items[3];
                        ECustomerType eCustomerType = ECustomerType.find(items[4]);
                        //id, String name, String address, String telephone
                        Customer customer = new Customer(idCustomer, fullName, address, phone);
                        customer.seteCustomerType(eCustomerType);
                        datas.add((T) customer);
                        break;
                    case Config.TYPE_PRODUCT:
                        long idProduct = Long.parseLong(items[0]);
                        float price = Float.parseFloat(items[3]);
                        // cho nay can refactor
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                        Date date =  simpleDateFormat.parse(items[4]);

                        Product p = new Product(idProduct, items[1], items[2], price, date);
                        datas.add((T) p);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return datas;
    }

    public static <T> void writeFile(String path, List<T> datas) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (T p : datas) {
                bufferedWriter.write(p.toString());
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
