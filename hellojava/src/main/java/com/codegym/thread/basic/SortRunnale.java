package com.codegym.thread.basic;

public class SortRunnale implements Runnable{

    private int [] arr;

    public SortRunnale(int[] arr) {
        this.arr = arr;
    }
    @Override
    public void run() {
        Basic.interchangeSort(arr);       //15p
    }
}
