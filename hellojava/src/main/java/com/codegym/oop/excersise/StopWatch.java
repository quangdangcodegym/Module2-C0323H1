package com.codegym.oop.excersise;

import com.codegym.sort.Sort;

public class StopWatch {
    private long startTime;     // 0L
    private long endTime;

    public StopWatch() {
        startTime = System.currentTimeMillis();
    }
    public void start() {
        startTime = System.currentTimeMillis();
    }
    public void stop() {
        endTime = System.currentTimeMillis();
    }
    public long getElapsedTime() {
        return endTime - startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 10
        int[] arr = Sort.createArray(1000000, 1000, 10);
        Sort.selectionSort(arr);

        stopWatch.stop();
        System.out.println("Thoi gian da troi qua: " + stopWatch.getElapsedTime());
    }
}
