package com.codegym.oop;

import java.util.Scanner;

public class OOPMain {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {


    }
    public static void basicWrapperClass() {
        /**
         Wrapper:   + kiểu đối tượng, Interger, Float, Double, String
         + 8: int (Integer),long (Long), short boolean (Bloean)
         Wrapper:
         + cung cấp thêm cáp phương thuc để thao tác dữ liệu: Integer.parseInt(str);
         + int a = 5;
         + autoboxing: Integer a1  = a;
         + unboxing: int b = a1;
         String str = "5";
         Integer.parseInt(str);
         **/
    }
    public static void basicScanner() {
        System.out.println("Nhập vào 1 số:");
//        int num = scanner.nextInt();        // 5enter
//        scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(num);

        System.out.println("Nhập vào name chuỗi");
        String name = scanner.nextLine();       //enter
        System.out.println(name);

        System.out.println("Nhập vào address chuỗi");
        String address = scanner.nextLine();
        System.out.println(address);
    }
}
