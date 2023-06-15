package com.codegym.thread.basic;

public class Basic {


    private static  int MAX = 100;
    private static int MIN = 10;

    public static void main(String[] args) {
        int size = 1000000;
        int[] arr = new int[size];
        System.out.println("Tạo mảng");
        creatArray(arr);    // 1s

        System.out.println("Bắt đầu sort");

        /** Cach 1: trien khai interface Runnable
//        SortRunnale sortRunnale = new SortRunnale(arr);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                interchangeSort(arr);
            }
        });
        t1.start();

         // Cach 2: kế thừa 1 thread
         ThreadSort threadSort = new ThreadSort();
         threadSort.setArr(arr);
         threadSort.start();

         Thread thread = new Thread(){
        @Override
        public void run() {
        interchangeSort(arr);
        }
        };
         thread.start();

         new Thread(){
        @Override
        public void run() {
        interchangeSort(arr);
        }
        }.start();
         **/


        System.out.println("Đi hẹn hò thôi nào");

    }
    public static void interchangeSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length; j++) {
                System.out.printf("i: %s - j:%s \n", i,j);
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    private static void creatArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*(MAX -MIN +1) + MIN);
        }
    }
}
