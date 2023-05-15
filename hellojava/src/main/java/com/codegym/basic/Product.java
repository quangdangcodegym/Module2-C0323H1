package com.codegym.basic;


import java.util.Scanner;

public class Product {
//    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // console.log('aaaaaaaa');
        System.out.println("Hello C0323H1");            // sout
        // let,var age = 5;
        // let name = "Quang";
        int age = 5;
        String name = "Quang";

        int avg = 8;
        if (avg >= 8) {
            System.out.println("Học sinh giỏi");
        }

        // promt("Nhập a");

        Scanner scanner = new Scanner(System.in);



        System.out.println("Nhập vào tên bạn đi:");
        String ten = scanner.nextLine();
        System.out.println("Tên bạn là: " + ten);

        System.out.println("Nhập so b:");
        int b = scanner.nextInt();
        System.out.println("Giá trị b là: " + b);
    }
}
