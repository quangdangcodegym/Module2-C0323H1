package com.codegym.baitap;

import java.util.Scanner;

public class Excersice {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // biến này để cho lặp lại
        boolean checkActionMenu;
        do{
            checkActionMenu = false;
            System.out.println("Chọn bài tập để xem:");
            System.out.println("Nhập 1: Tính tổng các giá trị lớn hơn giá trị đứng liền trước nó trong mảng 1 chiều các số thực");
            System.out.println("Nhập 2: Tính trung bình cộng các số dương trong mảng 1 chiều các số thực");
            System.out.println("Nhập 3: Đưa các số chia hết cho 3 về đầu mảng");
            System.out.println("Nhập 16: Liệt kê các dòng giảm dần trong ma trận");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    excersise1();
                    break;
                case 2:
                    excersise2();
                    break;
                case 16:
                    excersise16();
                    break;
            }
            System.out.println("Bạn có muốn tiếp tục hay không");
            System.out.println("Nhập Y: YES");
            System.out.println("Nhập N: NO");
            String actionContinue = scanner.nextLine();
            switch (actionContinue) {
                case "Y":
                    checkActionMenu = true;
                    break;
                case "N":
                    checkActionMenu = false;
                    break;

            }
        }while (checkActionMenu);



    }

    private static void excersise16() {
        int[][] arr = {
                {5, 1, 7, 9},
                {9, 7, 5, 1},
                {10, 7, 1, 0},
                {8, 9, 1, 3}
        };
        dispayRowDecrease(arr);
    }

    private static void excersise2() {
        float[] arr = {1.3f, -4.5f, 6.7f, 6.5f, 5.0f};
        float total = avgPositiveNumber(arr);
        System.out.println("Tổng trung bình các số thực lớn hơn 0 " + total);
    }

    private static void excersise1() {
        int[] arr1 = {3, 6, 2, 6, 8, 1};
        int total = sumLargerBeforeItem(arr1);
        System.out.println("Tổng giá trị trong mảng là: " + total);
    }

    public static void dispayRowDecrease(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr[i].length-1; j++) {
                if (arr[i][j + 1] > arr[i][j]) {
                    flag = false;
                    break;
                }
            }
            if (flag == true) {
                System.out.printf("Dong %s giam dan\n", i);
            }
        }
    }

    public static int sumLargerBeforeItem(int[] arr) {
        int sum = 0;
        if (arr.length > 0) {
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > arr[i - 1]) {
                    sum += arr[i];
                }
            }
        } else if (arr.length == 1) {
            return arr[0];
        }
        System.out.println("A");
        System.out.println("B");
        System.out.println("C");
        System.out.println("aaaaaaaaaaa");
        return sum;
    }

    public static float avgPositiveNumber(float[] arr) {
        float sum = 0;
        int count  = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
                count++;
            }
        }
        return sum/count;
    }

    public static void moveNumberToFirstArray(int [] arr, int number ){
        int temp;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] % number == 0) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    break;
                }
            }
        }
    }
}
