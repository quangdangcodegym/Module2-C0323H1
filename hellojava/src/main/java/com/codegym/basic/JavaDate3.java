package com.codegym.basic;

public class JavaDate3 {
    public static void main(String[] args) {
        // let arr = new Array();
        // let arr1 = [3,6,7,8];

//        int[] a = {5, 7, 1, 5, 1};
//        int[] b = {3, 3};
//
//        a = concat(a, b);
//        System.out.println(toString(a));
        int a = 5;
        int b = 10;
        swap(a, b);
        System.out.println("a: " + a + " - b: " + b);

    }

    public static void swap(int a1, int b1) {
        int temp = a1;
        a1 = b1;
        b1 = temp;
    }
    public static int [] concat(int[] arr1, int[] arr2) {
        int[] arrNew = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            arrNew[i] = arr1[i];
        }
        for (int j = 0; j < arr2.length; j++) {
            arrNew[arr1.length + j] = arr2[j];
        }
        return arrNew;
    }
    public static String toString(int[] a) {
        // [5, 7, 1, 5, 1]
        String str = "[";
        for (int i = 0; i < a.length; i++) {
            str += a[i];
            if (i == a.length - 1) {
                str += "]";
            }else{
                str += ",";
            }
        }
        return str;
    }
    public static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1-i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }

    public static int sumArray(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }
}
