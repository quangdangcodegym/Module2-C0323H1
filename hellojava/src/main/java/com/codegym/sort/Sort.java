package com.codegym.sort;

import java.util.Arrays;

public class Sort {
    public int MAX = 10;
    public static void main(String[] args) {
        int[] arr = {5, 1, 7, 2, 4};
        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] createArray(int size, int MAX, int MiN) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random()*(MAX - MiN + 1) + MiN);
        }

        return arr;
    }
    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int min = numbers[i];
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }
    }
    // truyền tham chiếu
    public static void interchangeSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
