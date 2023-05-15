package com.codegym.search;

public class SearchMain {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4,6, 8, 9};
        // tìm vị trí cua so 8

        System.out.println("Vi tri cu so 9: " + findIndex(arr, 8));
    }
    public static int findIndex(int [] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
