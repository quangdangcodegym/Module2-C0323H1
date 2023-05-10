package com.codegym;

import java.util.Scanner;

public class JavaBasic {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        float avg = 8.5f;

        System.out.println(getRank(avg));
    }

    public static String getRank(float avg) {
        if (avg >= 8 && avg <= 10) {
            return "Gioi";
        } else if (avg >= 5 && avg < 8) {
            return "Kha";
        } else if (avg >= 0 && avg < 5) {
            return "Trung binh";
        }else {
            return "Khong hop le";
        }
    }
    public static void convertCurrency() {
        int rate = 23000;
        int choice = -1;


        boolean checkInputContinue = false;
        do {
            checkInputContinue = false;
            System.out.println("Bạn muốn nhập tiền USD hay VND");
            System.out.println("Chọn 1.Nhập USD");
            System.out.println("Chọn 2. Nhập VND");
            choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Nhập không đúng vui lòng nhập lại");
                checkInputContinue = true;
            }
        } while (checkInputContinue);


        System.out.println("Nhập vào số tiền USD: ");
        double money = scanner.nextDouble();
        double total = 0;

        switch (choice) {
            case 1:
                total = money*23000;
                System.out.printf("%s USD tuong đương với %.0f tiền VND", money, total);
                break;
            case 2:
                total = money / 23000;
                System.out.printf("%s VND tuong đương với %.3f tiền USD", money, total);

        }

    }
    public static void basicJava1() {
        /**
         System.out.println("Nhập vào 1 số:");
         int num = scanner.nextInt();

         int total  = 0;
         for (int i = 1; i < num; i++) {
         total += i;
         }
         System.out.println("Tổng từ 1 đến " + num + " là " + total );
         **/

        /**
         int age = -1;
         do {
         System.out.println("Nhap vao tuổi: ");
         age = scanner.nextInt();
         } while (age < 0);


         int age = -1;
         do {
         System.out.println("Nhap vao tuổi: ");
         age = scanner.nextInt();
         if (age < 0) {
         System.out.println("Tuổi phải  lớn hơn 0, vui lòng nhập lại tuổi");
         }
         } while (age < 0);


         System.out.println("Nhập vào 1 tháng in ra tháng đó có bao nhiêu ngày:");
         int month = scanner.nextInt();      //4
         switch (month) {
         case 1:
         case 3:
         case 5:
         case 7:
         System.out.println("Tháng này có 31 ngày");
         break;
         case 2:
         System.out.println("tháng có 28 ngày");
         break;
         case 4:
         case 6:
         case 9:
         System.out.println("Thang có 30 ngày");
         break;
         default:
         System.out.println("Tháng ko hợp lệ");
         }

         System.out.println("Nhap vao 1 so, kiểm tra xem có phaải là số nguyên tố ko ");
         int num = scanner.nextInt();



         // 8: số nguyên: byte, short, int, long
         int a = 129;
         **/

        /*

        function tenHam(num1, num2){
            return giatri;   // co the co return hoac khong
        }
         */

//        printOneToNumber(100);

    }
    public static void basicPrintf() {
        System.out.printf("%.3f la so thap phan\n", 10.456789);
        System.out.printf("%20s | %10s | %20s\n", "NAME", "AGE", "SDT");
        System.out.printf("%20s | %10s | %-20s\n", "Quang Dang", 18, "0399578133");
        System.out.printf("%20s | %10s | %-20s\n", "Quang Dangsssssss", 18, "03955555559578133");
        System.out.printf("%20s | %10s | %-20s\n", "Quang Dang123", 18, "0399578133");
    }
    public static boolean isPrime(int num) {
        boolean flag = true;
        if (num < 2) {
            flag = false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void printOneToNumber(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.println(i);
        }
    }
    public static int sum(int num1, int num2) {
        return num1+num2;
    }

    public static void aPlus() {
        int a  = 5;
        int b = a++ + ++a*3;
        System.out.println(a);
        System.out.println(b);
        // Nhân a = 6, b= 23;
        // Thắng: a = 7, b = 24;
        // Hiếu a = 7, b = 23; Bảo

        /**
         int a = 1;
         do {
         ++a;
         } while (a++ < 10);
         System.out.println(a);
         */
    }
}
