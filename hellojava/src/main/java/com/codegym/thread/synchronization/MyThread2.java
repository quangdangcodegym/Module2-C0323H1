package com.codegym.thread.synchronization;

class MyThread2 extends Thread {
    Table t;        // con nớ

    MyThread2(Table t) {
        this.t = t;
    }

    public void run() {
        t.printTable(100);
    }
}