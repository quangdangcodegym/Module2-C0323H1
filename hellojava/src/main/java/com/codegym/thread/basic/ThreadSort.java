package com.codegym.thread.basic;

public class ThreadSort extends Thread{
    private int [] arr;


    public void setArr(int[] arr) {
        this.arr = arr;
    }
    @Override
    public void run() {
        Basic.interchangeSort(arr);
    }
}
