package com.codegym;

import java.util.Scanner;

public class JavaBasic {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

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
         **/

        System.out.println("Nhap vao 1 so, kiểm tra xem có phaải là số nguyên tố ko ");
        int num = scanner.nextInt();

        boolean flag = true;
        if (num < 2) {
            System.out.println(num + "Không phải la so nguyen to");
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            System.out.println(num + "Là số nguyên tố");
        }else{
            System.out.println(num + "Không phải là số nguyên tố");
        }


    }
}
