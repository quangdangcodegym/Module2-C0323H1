package com.codegym.thread.synchronization;

public class Main {
    public static void main(String[] args) {
        Table table = new Table();      // con ghẹ

//        Thread thread1 = new MyThread1(table);      // đạt
//        thread1.start();

        /*Thread thread1 = new Thread(){
            @Override
            public void run() {
                table.printTable(10);
            }
        };
        thread1.start();*/

        new Thread(new Runnable() {
            @Override
            public void run() {
                table.printTable(10);
            }
        }).start();

        Thread thread2 = new MyThread2(table);       // hưng
        thread2.start();
    }
}
