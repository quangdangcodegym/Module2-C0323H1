package com.codegym.search;

import java.util.Arrays;

public class BinarySearch {
    static int[] list = {1,5,6,8,9,2,12};

    public static void main(String[] args) {
//        binarySearch(list, 79);
        moveNumberToFirstArray(list, 3);
        System.out.println(Arrays.toString(list));
    }

    /**
     *
     * @param arr
     * @param number
     */
    public static void moveNumberToFirstArray(int [] arr, int number ){
        int temp;
        for (int i = 0; i < list.length-1; i++) {
            for (int j = i+1; j < list.length; j++) {
                if (list[j] % number == 0) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    break;
                }
            }
        }
    }
    static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1; /* Now high < low, key not found */
    }
}

