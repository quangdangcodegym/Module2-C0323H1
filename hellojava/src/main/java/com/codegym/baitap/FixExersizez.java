package com.codegym.baitap;

import java.util.Arrays;

public class FixExersizez {
    public static void main(String[] args) {
        int[] arr = {5, 2, -6, 3, 5, 8, -9, -10};
        for (int i =0; i < arr.length; i++){
            for (int j = arr.length -1; j > i; j--){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
