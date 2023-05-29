package com.codegym.generic;

public class MyGeneric1 {
    String obj;

    void add(String obj) {
        this.obj = obj;
    }

    String get() {
        return obj;
    }

    public static void main(String[] args) {
        MyGeneric1 myGeneric = new MyGeneric1();
        myGeneric.add("Minh");

    }
}
