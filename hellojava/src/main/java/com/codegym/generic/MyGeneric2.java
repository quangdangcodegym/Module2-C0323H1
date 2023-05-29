package com.codegym.generic;

class MyGeneric2 {
    Integer obj;

    void add(Integer obj) {
        this.obj = obj;
    }

    Integer get() {
        return obj;
    }

    public static void main(String[] args) {
        MyGeneric2 myGeneric = new MyGeneric2();
        myGeneric.add(5);

    }
}